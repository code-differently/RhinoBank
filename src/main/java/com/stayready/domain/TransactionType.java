package com.stayready.domain;

public enum TransactionType {

        P2P("P2p"),
        DEPOSIT("Deposit"),
        WITHDRAW("Withdrawal");

        private String transactionType;


        TransactionType(String transactionType)
        {
            this.transactionType = transactionType;
        }


        public String getTransactionType()
        {
            return transactionType;
        }

        public void setTransactionType(String transactionType)
        {
            this.transactionType = transactionType;
        }

}
