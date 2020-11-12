package com.compname.orders.api.model;

public class Geolocation {

    private Float longitude;
    private Float latitude;

    public Geolocation(Float longitude, Float latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Float getLatitude() {
        return latitude;
    }
}
