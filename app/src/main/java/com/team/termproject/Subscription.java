package com.team.termproject;

import java.util.Date;

public class Subscription {
    private String name;
    private Date payDate;
    private String amount;
    private String imgURL;

    public Subscription(String name, Date payDate, String amount, String imgURL) {
        this.name = name;
        this.payDate = payDate;
        this.amount = amount;
        this.imgURL = imgURL;
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

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
