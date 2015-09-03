package com.melayer.dto;

/**
 * Created by root on 9/3/15.
 */
public class MeDevice {

    private String imei;
    private String userName;
    private String mobileNumber;
    private String userDistrict;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserDistrict() {
        return userDistrict;
    }

    public void setUserDistrict(String userDistrict) {
        this.userDistrict = userDistrict;
    }

    @Override
    public String toString() {
        return "MeDevice{" +
                "imei='" + imei + '\'' +
                ", userName='" + userName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", userDistrict='" + userDistrict + '\'' +
                '}';
    }
}
