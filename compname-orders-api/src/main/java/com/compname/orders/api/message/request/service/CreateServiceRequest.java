package com.compname.orders.api.message.request.service;

import com.compname.orders.api.message.request.BasicEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CreateServiceRequest extends BasicEntity {

    private Long businessId;
    private Float price;
    private String duration;

    public CreateServiceRequest(Long id, String name, String createdBy, Long businessId, Float price, String duration) {
        super(id, name, createdBy);
        this.businessId = businessId;
        this.price = price;
        this.duration = duration;
    }

    public CreateServiceRequest(String name, String createdBy, Long businessId, Float price, String duration) {
        super(name, createdBy);
        this.businessId = businessId;
        this.price = price;
        this.duration = duration;
    }
}
