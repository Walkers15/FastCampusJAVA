package com.example.postdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequestDTO {
    private String account;
    private String email;
    private String address;
    private String password;

    // Object Mapper 라는놈이 있으면 케이싱을 바꿔줄 수 있음
    // 아니면 이렇게 @JsonProperty 를 사용하면 됨
    @JsonProperty("phone_number")
    private String phoneNumber; // phone_number

    // snake, camel 도 아닐 때도 아닌 약어 등을 사용할 때도 활용함
    @JsonProperty("OTP")
    private String OTP;

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "PostRequestDTO{" +
                "account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", OTP='" + OTP + '\'' +
                '}';
    }
}
