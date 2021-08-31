package com.alin.titi.services;

import com.alin.titi.model.LoginModel;
import com.alin.titi.model.PasswordResetToken;
import com.alin.titi.model.api.response.LoginResponse;
import com.alin.titi.repository.LoginRepository;
import com.alin.titi.repository.PasswordTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public LoginResponse findAccountLoginStatus(String account,String password) {
          LoginModel loginModel=loginRepository.findByAccountAndPassword(account,password);
          LoginResponse response=new LoginResponse();
          response.setTchNumber(loginModel.getId());

          loginModel.setNumberOfmain_logins(loginModel.getNumberOfmain_logins()+1);


            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Taipei"));
            Date now = new Date();
          loginModel.setLastTime(now);
          return response;
    }

    public void changeUserPassword(String password,LoginModel loginModel){
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
        LoginModel loginModel=loginRepository.findByAccount(account);

        return loginModel;
    }
    public LoginModel findByLoginId(Integer account) {
        LoginModel loginModel=loginRepository.findById(account);

        return loginModel;
    }

    public String validatePasswordResetToken(String token) {
        final PasswordResetToken passToken = passwordTokenRepository.findByToken(token);

        if (isTokenFound(passToken) && !isTokenExpired(passToken)){
            return "ok";
        }
        else {
            if (!isTokenFound(passToken)){
                return "invalidToken";
            }
            if ( isTokenExpired(passToken)){
                return "expired";
            }
        }
        return null;
    }


    public Integer findLoginId(String token){
        final PasswordResetToken passToken = passwordTokenRepository.findByToken(token);

        return passToken.getUser().getId();
    }
    private boolean isTokenFound(PasswordResetToken passToken) {
        return passToken != null;
    }

    private boolean isTokenExpired(PasswordResetToken passToken) {
        final Calendar cal = Calendar.getInstance();
        System.out.println("bool    :   "+passToken.getExpiryDate().before(cal.getTime()));
        return passToken.getExpiryDate().before(cal.getTime());
    }

}
