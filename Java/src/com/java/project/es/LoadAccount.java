package com.java.project.es;

import java.util.Date;

public class LoadAccount extends Account {
    private double loanRate;
    private Date reDate;

    public double getLoanRate() {
        return loanRate;
    }

    public void setLoanRate(double loanRate) {
        this.loanRate = loanRate;
    }

    public Date getReDate() {
        return reDate;
    }

    public void setReDate(Date reDate) {
        this.reDate = reDate;
    }
}
