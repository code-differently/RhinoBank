package com.stayready.domain;

public enum AccountType
{
    SAVINGS("Savings"),
    CHECKINGS("Checkings"),
    CREDIT("Credit");

    private String accountType;


    AccountType(String accountType)
    {
        this.accountType = accountType;
    }


    public String getAccountType()
    {
        return this.accountType;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }
}
