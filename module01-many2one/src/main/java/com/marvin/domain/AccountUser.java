
/*
 * @author: marvin
 * @software: IntelliJ IDEA
 * @file: AccountUser.java
 * @time: 2020-05-17 10:39
 */

package com.marvin.domain;

import java.io.Serializable;

public class AccountUser extends Account implements Serializable {
    private String userName;
    private String userAddress;

    @Override
    public String toString() {
        return super.toString() + "AccountUser{" +
                "userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
