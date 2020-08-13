package com.stayready.domain;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @Column(name = "ACCOUNT_TYPE")
    private String type;

    @Column(name = "ACCOUNT_NICKNAME")
    private String nickname;

    @Column(name = "ACCOUNT_REWARDS")
    private int rewards;

//    @ManyToOne
//    @JoinColumn(name = "CUSTOMER_ID")
//    private Long customerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getRewards() {
        return rewards;
    }

    public void setRewards(int rewards) {
        this.rewards = rewards;
    }

//    public Long getCustomerId() {
//        return this.customerId;
//    }
//
//    public void setCustomerId(Long customerId) {
//        this.customerId = customerId;
//    }
}
