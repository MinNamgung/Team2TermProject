package com.team.termproject;

import java.util.Date;

public class Subscription {
    private String name;
    private Date payDate;
    private String amount;

    public Subscription(String name, Date payDate, String amount) {
        this.name = name;
        this.payDate = payDate;
        this.amount = amount;
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
