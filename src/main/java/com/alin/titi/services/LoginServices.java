package com.alin.titi.services;

import com.alin.titi.model.LoginModel;
import com.alin.titi.model.PasswordResetToken;
import com.alin.titi.model.api.response.LoginResponse;
import com.alin.titi.model.api.response.LoginWithGradeResponse;
import com.alin.titi.repository.LoginRepository;
import com.alin.titi.repository.PasswordTokenRepository;
import com.alin.titi.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Service
@Transactional
public class LoginServices {
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PasswordTokenRepository passwordTokenRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public LoginWithGradeResponse findAccountLoginStatus(String account, String password) {
        LoginModel loginModel = loginRepository.findByAccount(account);
        LoginWithGradeResponse response = new LoginWithGradeResponse();
        response.setTchNumber(loginModel.getId());
        response.setGrade(loginModel.getGrade());
        loginModel.setNumberOfmain_logins(loginModel.getNumberOfmain_logins() + 1);


        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Taipei"));
        Date now = new Date();
        loginModel.setLastTime(now);

        // 验证登录密码是否正确。如果正确，则赋予用户相应权限并生成用户认证信息
        if (this.bCryptPasswordEncoder.matches(password, loginModel.getPassword())) {
//            List<String> roles = userService.listUserRoles(userName);
            // 如果用户角色为空，则默认赋予 ROLE_USER 角色
//            if (CollectionUtils.isEmpty(roles)) {
//                roles = Collections.singletonList(UserRoleConstants.ROLE_USER);
//            }
            // 生成 token
            String token = JwtUtils.generateToken(account, true);


            // 认证成功后，设置认证信息到 Spring Security 上下文中
            Authentication authentication = JwtUtils.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 用户信息
//            UserDTO userDTO = new UserDTO();
//            userDTO.setUserName(userName);
//            userDTO.setEmail(user.getEmail());
//            userDTO.setRoles(roles);
//
            response.setToken(token);


            return response;
        }
        //打斷
        throw new BadCredentialsException("The user name or password error.");
    }

    public void changeUserPassword(String password, LoginModel loginModel) {
        loginModel.setPassword(password);
        loginRepository.save(loginModel);

    }

    public void createPasswordResetTokenForUser(LoginModel user, String token) {
        PasswordResetToken myToken = new PasswordResetToken(token, user);
        Calendar date = Calendar.getInstance();
        System.out.println("Current Date and TIme : " + date.getTime());
        long timeInSecs = date.getTimeInMillis();
        Date afterAdding10Mins = new Date(timeInSecs + (30 * 60 * 1000));
        myToken.setExpiryDate(afterAdding10Mins);
        passwordTokenRepository.save(myToken);
    }

    public LoginModel findAccountAndEmail(String account) {
        LoginModel loginModel = loginRepository.findByAccount(account);

        return loginModel;
    }

    public LoginModel findByLoginId(Integer account) {
        LoginModel loginModel = loginRepository.findById(account);

        return loginModel;
    }

    public String validatePasswordResetToken(String token) {
        final PasswordResetToken passToken = passwordTokenRepository.findByToken(token);

        if (isTokenFound(passToken) && !isTokenExpired(passToken)) {
            return "ok";
        } else {
            if (!isTokenFound(passToken)) {
                return "invalidToken";
            }
            if (isTokenExpired(passToken)) {
                return "expired";
            }
        }
        return null;
    }

    public void deleteToken(String token) {
        PasswordResetToken passToken = passwordTokenRepository.findByToken(token);
        passwordTokenRepository.delete(passToken);
    }

    public Integer findLoginId(String token) {
        final PasswordResetToken passToken = passwordTokenRepository.findByToken(token);

        return passToken.getUser().getId();
    }

    private boolean isTokenFound(PasswordResetToken passToken) {
        return passToken != null;
    }

    private boolean isTokenExpired(PasswordResetToken passToken) {
        final Calendar cal = Calendar.getInstance();
        System.out.println("bool    :   " + passToken.getExpiryDate().before(cal.getTime()));
        return passToken.getExpiryDate().before(cal.getTime());
    }

}
