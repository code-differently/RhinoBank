package com.stayready.domain;

public enum Status {
    //serialize to a string
    PENDING("Pending"),
    CANCELLED("Cancelled"),
    COMPLETED("Completed"),
    RECURRING("Recurring");

    private String status;

    //constructor initializing the status
    Status(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
