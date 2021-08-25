package com.alin.titi.model;

public class LoginRequest {
    private String  account="";
    private String password="";

    public String getAccount() {
        return account;
    }

    public void setAccout(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
