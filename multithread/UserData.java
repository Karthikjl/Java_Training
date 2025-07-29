package com.celcom.multithread;

public class UserData {
    private String phoneNumber;
    private String emailAddress;

    public UserData(String phoneNumber, String emailAddress) {
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
