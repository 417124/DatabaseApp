package com.project.databaseapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "Devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private Long deviceId;
    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "device_type")
    private String deviceType;

    @Column(name = "device_status")
    private String deviceStatus;

    public Device(){}; // konstruktor domyslny dla JPA
    public Device(String deviceName, String deviceType, String deviceStatus){ // konstruktor
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.deviceStatus = deviceStatus;
    }

    // gettery i settery

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        return deviceId != null ? deviceId.equals(device.deviceId) : device.deviceId == null;
    }

    @Override
    public int hashCode() {
        return deviceId != null ? deviceId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", deviceName='" + deviceName + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", deviceStatus='" + deviceStatus + '\'' +
                '}';
    }
}
