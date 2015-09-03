package com.melayer.dto;

/**
 * Created by root on 9/3/15.
 */
public class MeInfo {

    private String status;
    private String actor;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MeInfo{" +
                "status='" + status + '\'' +
                ", actor='" + actor + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
