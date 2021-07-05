package com.stayready.enums;

public enum Medium {
    BALANCE("balance"), REWARDS("rewards");
    private String typeOfMedium;

    Medium(String typeOfMedium) {
        this.typeOfMedium = typeOfMedium;
    }

    public String getMedium() {
        return this.typeOfMedium;
    }
}