package com.alin.titi.services;

import com.alin.titi.model.AuthorModel;
import com.alin.titi.model.LoginModel;
import com.alin.titi.model.LoginResponse;
import com.alin.titi.repository.AuthorRepository;
import com.alin.titi.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
@Transactional
public class LoginServices {
    @Autowired
    private LoginRepository loginRepository;

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

}
