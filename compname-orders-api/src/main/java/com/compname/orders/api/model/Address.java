package com.compname.orders.api.model;

public class Address {

    private String city;
    private Integer postalCode;
    private String address;

    public Address(String city, Integer postalCode, String address) {
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public String getAddress() {
        return address;
    }
}
