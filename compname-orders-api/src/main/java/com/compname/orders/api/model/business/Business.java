package com.compname.orders.api.model.business;

import com.compname.orders.api.model.ApiBasicEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Business extends ApiBasicEntity {

    private Long oib;
    private Address address;
    private ContactInfo contactInfo;
    private Geolocation geolocation;
    private Float rating;
    private String minInterval;

    public Business(Long id, String name, ZonedDateTime created, String createdBy, Long oib, Address address, ContactInfo contactInfo, Geolocation geolocation, Float rating, String minInterval) {
        super(id, name, created, createdBy);
        this.oib = oib;
        this.address = address;
        this.contactInfo = contactInfo;
        this.geolocation = geolocation;
        this.rating = rating;
        this.minInterval = minInterval;
    }

    public Business(String name, ZonedDateTime created, String createdBy, Long oib, Address address, ContactInfo contactInfo, Geolocation geolocation, Float rating, String minInterval) {
        super(name, created, createdBy);
        this.oib = oib;
        this.address = address;
        this.contactInfo = contactInfo;
        this.geolocation = geolocation;
        this.rating = rating;
        this.minInterval = minInterval;
    }
}
