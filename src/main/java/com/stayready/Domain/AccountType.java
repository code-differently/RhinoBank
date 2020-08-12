package com.stayready.Domain;

public enum AccountType {
    CHECKING("Checking"), SAVINGS("Savings"), CREDIT("Credit");

    private final String accountType;

    private AccountType(String accountType){
        this.accountType = accountType;
    }

    public String returnAccountType(){
        return accountType;
    }
}