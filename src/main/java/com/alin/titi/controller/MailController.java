package com.alin.titi.controller;

import com.alin.titi.model.LoginModel;
import com.alin.titi.model.PasswordResetToken;
import com.alin.titi.model.api.request.PasswordDto;
import com.alin.titi.model.api.response.GenericResponse;
import com.alin.titi.services.LoginServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class MailController {
    @Autowired
    JavaMailSender mailSender;

    @Autowired
    LoginServices loginServices;
    @PostMapping("/teacher/sendEmail")
    void sendToGmail() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("omkkqq@gmail.com");
        message.setSubject("sendEmail Gmail sendEmail");
        message.setText("org.springframework.mail.SimpleMailMessage 透過 Gmail 發信。");

        mailSender.send(message);
    }


    @PostMapping("/teacher/resetPassword")
    public void resetPassword(
            @RequestParam("email") String userEmail) throws Exception {
        LoginModel user = loginServices.findAccountAndEmail(userEmail);
        if (user == null) {
            throw new Exception("user not founded");
        }
        String token = UUID.randomUUID().toString();
        loginServices.createPasswordResetTokenForUser(user, token);
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Taipei"));
        Date now = new Date();
        mailSender.send(constructResetTokenEmail(
                now.getTime(), token, user));
    }

    @GetMapping("/teacher/changePassword")
    public String showChangePasswordPage(@RequestParam("token") String token) {
        String result = loginServices.validatePasswordResetToken(token);
        if(result.equals("ok")) {

            return "ok"+"<script language=\"javascript\">document.location.href=\"http://localhost/aaa.html?token="+token+"\";</script>\n";

        } else { ;
            return result+" :error";
        }
    }

    @PostMapping("/teacher/savePassword")
    public String savePassword(@RequestBody  PasswordDto passwordDto) {

        String result = loginServices.validatePasswordResetToken(passwordDto.getToken());

        if(!result.equals("ok")) {
            return "error:  "+result;
        }

        Integer id  = loginServices.findLoginId(passwordDto.getToken());
        LoginModel loginModel=loginServices.findByLoginId(id);
        if(loginModel !=null) {
            loginServices.changeUserPassword(passwordDto.getNewPassword(),loginModel);
            loginServices.deleteToken(passwordDto.getToken());
            return "success";
        } else {
            return "can't not find user";
        }
    }


    private SimpleMailMessage constructResetTokenEmail(
            Long locale, String token, LoginModel user) {
        String url = "http://localhost:8080" + "/teacher/changePassword?token=" + token;
        String message ="message.resetPassword"+String.valueOf(locale);

        return constructEmail("Reset Password", message + " \r\n" + url, user);
    }

    private SimpleMailMessage constructEmail(String subject, String body,
                                             LoginModel user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getAccount());
        return email;
    }
}