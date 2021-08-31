package com.alin.titi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PasswordResetToken {

    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    private String token;

    @OneToOne(targetEntity = LoginModel.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private LoginModel user;


    private Date expiryDate;

    public PasswordResetToken() {
    }

    public PasswordResetToken(Long user_id, String token, LoginModel user, Date expiryDate) {
        this.user_id = user_id;
        this.token = token;
        this.user = user;
        this.expiryDate = expiryDate;
    }

    public PasswordResetToken(String token, LoginModel user) {
        this.token = token;
        this.user = user;
    }

    public static int getEXPIRATION() {
        return EXPIRATION;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginModel getUser() {
        return user;
    }

    public void setUser(LoginModel user) {
        this.user = user;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
