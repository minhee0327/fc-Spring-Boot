package com.example.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequest {
    private String account;
    private String email;
    private String password;
    private String address;
    @JsonProperty("phone_number")
    private String phoneNumber; //json key: phone_number; ObjectMapping(text-> ojbect )

    @JsonProperty("OTP")
    private String OTP; //camel 도 아니고 snake 도 아님 이럴땐?

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PostRequest{" +
                "account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", OTP='" + OTP + '\'' +
                '}';
    }
}
