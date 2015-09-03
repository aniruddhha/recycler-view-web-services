package com.melayer.model;

/**
 * Created by root on 9/3/15.
 */
public class MeDeviceModel {

    //{"deviceId":1234,
    // "adminId":231,
    // "deviceUserName":"Mama",
    // "deviceImei":"123456789012345",
    // "deviceMobileNumber":"+91 945 235 9045",
    // "pushNotificationId":null,
    // "dateTimeStamp":1441286584685,
    // "intervalTracking":null,
    // "isTrackingOn":null,
    // "district":null}

    private Long deviceId;
    private Long adminId;
    private String deviceUserName;
    private String deviceImei;
    private String deviceMobileNumber;
    private String pushNotificationId;
    private Long dateTimeStamp;
    private Integer intervalTracking;
    private Boolean isTrackingOn;
    private String district;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getDeviceUserName() {
        return deviceUserName;
    }

    public void setDeviceUserName(String deviceUserName) {
        this.deviceUserName = deviceUserName;
    }

    public String getDeviceImei() {
        return deviceImei;
    }

    public void setDeviceImei(String deviceImei) {
        this.deviceImei = deviceImei;
    }

    public String getDeviceMobileNumber() {
        return deviceMobileNumber;
    }

    public void setDeviceMobileNumber(String deviceMobileNumber) {
        this.deviceMobileNumber = deviceMobileNumber;
    }

    public String getPushNotificationId() {
        return pushNotificationId;
    }

    public void setPushNotificationId(String pushNotificationId) {
        this.pushNotificationId = pushNotificationId;
    }

    public Long getDateTimeStamp() {
        return dateTimeStamp;
    }

    public void setDateTimeStamp(Long dateTimeStamp) {
        this.dateTimeStamp = dateTimeStamp;
    }

    public Integer getIntervalTracking() {
        return intervalTracking;
    }

    public void setIntervalTracking(Integer intervalTracking) {
        this.intervalTracking = intervalTracking;
    }

    public Boolean getIsTrackingOn() {
        return isTrackingOn;
    }

    public void setIsTrackingOn(Boolean isTrackingOn) {
        this.isTrackingOn = isTrackingOn;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
