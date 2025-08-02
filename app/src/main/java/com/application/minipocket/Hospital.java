package com.application.minipocket;

public class Hospital {
    private int id;
    private String name;
    private String location;
    private String address;
    private String phone_number;
    private int number_of_beds;
    private boolean has_emergency;
    private String image;

    public Hospital(int id, String name, String location, String address, String phone_number, int number_of_beds, boolean has_emergency, String image) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.address = address;
        this.phone_number = phone_number;
        this.number_of_beds = number_of_beds;
        this.has_emergency = has_emergency;
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

    public String getPhone_number() {
        return phone_number;
    }

    public int getNumber_of_beds() {
        return number_of_beds;
    }

    public boolean isHas_emergency() {
        return has_emergency;
    }

    public String getImage() {
        return image;
    }
}

