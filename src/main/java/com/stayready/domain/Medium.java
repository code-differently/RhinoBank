package com.stayready.domain;

public enum Medium {


        //serialize to a string
        BALANCE("Balance"),
        REWARDS("Rewards");


        private String medium;

        //constructor initializing the status
        Medium(String medium){
            this.medium = medium;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }






}
