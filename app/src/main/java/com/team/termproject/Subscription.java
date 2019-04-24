package com.team.termproject;

import java.util.Date;

public class Subscription {
    private String name;
    private int payDate;
    private String amount;
    private String memo;
    private String email;
    private String imgURL;

    public Subscription(String name, int payDate, String amount, String emial, String memo,String imgURL) {
        this.name = name;
        this.payDate = payDate;
        this.amount = amount;
        this.email = emial;
        this.memo = memo;
        this.imgURL = imgURL;

    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPayDate() {
        return payDate;
    }

    public void setPayDate(int payDate) {
        this.payDate = payDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
