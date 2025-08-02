package com.application.minipocket;

public class Directory {
    private int id;
    private String name;
    private String serviceType;
    private String phoneNumber;
    private String location;
    private String address;

    public Directory(int id, String name, String serviceType, String phoneNumber, String location, String address) {
        this.id = id;
        this.name = name;
        this.serviceType = serviceType;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.address = address;
    }

    // Getters and setters for all the fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

