package com.griddynamics.qa.vikta.uitesting.sample.elements;

public class Card {
    protected String number;
    protected String code;
    protected String owner;
    protected String expirationDate;
    protected String nickname;

    public Card() {

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String tags) {
        this.nickname = nickname;
    }
}
