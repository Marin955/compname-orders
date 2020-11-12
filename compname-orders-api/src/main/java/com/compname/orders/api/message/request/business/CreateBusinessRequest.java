package com.compname.orders.api.message.request.business;

import com.compname.orders.api.message.request.BasicEntity;
import com.compname.orders.api.model.Address;
import com.compname.orders.api.model.ContactInfo;
import com.compname.orders.api.model.Geolocation;

import java.time.ZonedDateTime;

public class CreateBusinessRequest extends BasicEntity {

    private Long oib;
    private Address address;
    private ContactInfo contactInfo;
    private Geolocation geolocation;
    private String minInterval;

    public CreateBusinessRequest(String name, ZonedDateTime created, String createdBy, Long oib, Address address, ContactInfo contactInfo, Geolocation geolocation, String minInterval) {
        super(name, created, createdBy);
        this.oib = oib;
        this.address = address;
        this.contactInfo = contactInfo;
        this.geolocation = geolocation;
        this.minInterval = minInterval;
    }

    public CreateBusinessRequest(Long id, String name, ZonedDateTime created, String createdBy, Long oib, Address address, ContactInfo contactInfo, Geolocation geolocation, String minInterval) {
        super(id, name, created, createdBy);
        this.oib = oib;
        this.address = address;
        this.contactInfo = contactInfo;
        this.geolocation = geolocation;
        this.minInterval = minInterval;
    }

    public void setOib(Long oib) {
        this.oib = oib;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    public void setMinInterval(String minInterval) {
        this.minInterval = minInterval;
    }
}
