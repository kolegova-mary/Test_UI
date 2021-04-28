package com.griddynamics.qa.vikta.uitesting.sample.elements;

public class Login {
    protected String loginname;
    protected String password;

    protected Login(String loginname, String password) {
        this.loginname = loginname;
        this.password = password;
    }

    public Login() {

    }

    public String getLoginname() {
        return loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
