package com.application.minipocket;

public class Supermarket {
    private int id;
    private String name;
    private String location;
    private String address;
    private String openTime;
    private String closeTime;
    private String offers;
    private String phoneNumber;
    private String image;

    public Supermarket(int id, String name, String location, String address, String phoneNumber, String openTime, String closeTime, String offers, String image) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.address = address;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.offers = offers;
        this.phoneNumber = phoneNumber;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getAddress() {
        return address;
    }

    public String getOpenTime() {
        return openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public String getOffers() {
        return offers;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

