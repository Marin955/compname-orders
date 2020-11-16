package com.compname.orders.api.model.service;

import com.compname.orders.api.model.ApiBasicEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Service extends ApiBasicEntity {
    private Long businessId;
    private Float price;
    private String duration;

    public Service(Long id, String name, ZonedDateTime created, String createdBy, Long businessId, Float price, String duration) {
        super(id, name, created, createdBy);
        this.businessId = businessId;
        this.price = price;
        this.duration = duration;
    }

    public Service(String name, ZonedDateTime created, String createdBy, Long businessId, Float price, String duration) {
        super(name, created, createdBy);
        this.businessId = businessId;
        this.price = price;
        this.duration = duration;
    }
}
