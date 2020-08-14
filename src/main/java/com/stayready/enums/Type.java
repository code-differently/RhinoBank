package com.stayready.enums;

public enum Type {
    SAVINGS("savings"), CHECKING("checking"), CREDIT("credit");

    private String typeOfAccount;

    Type(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    public String getAccountType() {
        return this.typeOfAccount;
    }
}
