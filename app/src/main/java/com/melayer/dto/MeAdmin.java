package com.melayer.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 9/3/15.
 */
public class MeAdmin {

    private Long adminId;
    private String adminName;
    private List<MeDevice> registeredDevices = new ArrayList<>();

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public List<MeDevice> getRegisteredDevices() {
        return registeredDevices;
    }

    public void setRegisteredDevices(List<MeDevice> registeredDevices) {
        this.registeredDevices = registeredDevices;
    }

    @Override
    public String toString() {
        return "MeAdmin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", registeredDevices=" + registeredDevices +
                '}';
    }
}
