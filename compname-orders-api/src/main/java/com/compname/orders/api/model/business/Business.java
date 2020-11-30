package com.compname.orders.api.model.business;

import com.compname.orders.api.model.ApiBasicEntity;
import com.compname.orders.api.model.employee.Employee;
import com.compname.orders.api.model.offer.Offer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

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
    private List<Offer> offers;
    private List<Employee> employees;

    public Business(Long id, String name, ZonedDateTime created, String createdBy, Long oib, Address address, ContactInfo contactInfo, Geolocation geolocation, Float rating, String minInterval, List<Offer> offers, List<Employee> employees) {
        super(id, name, created, createdBy);
        this.oib = oib;
        this.address = address;
        this.contactInfo = contactInfo;
        this.geolocation = geolocation;
        this.rating = rating;
        this.minInterval = minInterval;
        this.offers = offers;
        this.employees = employees;
    }

    public Business(String name, ZonedDateTime created, String createdBy, Long oib, Address address, ContactInfo contactInfo, Geolocation geolocation, Float rating, String minInterval, List<Offer> offers, List<Employee> employees) {
        super(name, created, createdBy);
        this.oib = oib;
        this.address = address;
        this.contactInfo = contactInfo;
        this.geolocation = geolocation;
        this.rating = rating;
        this.minInterval = minInterval;
        this.offers = offers;
        this.employees = employees;
    }
}
