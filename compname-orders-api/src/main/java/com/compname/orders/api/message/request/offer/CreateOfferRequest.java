package com.compname.orders.api.message.request.offer;

import com.compname.orders.api.message.request.ApiBasicEntityRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CreateOfferRequest extends ApiBasicEntityRequest {

    private Long businessId;
    private Float price;
    private String duration;

    public CreateOfferRequest(Long id, String name, String createdBy, Long businessId, Float price, String duration) {
        super(id, name, createdBy);
        this.businessId = businessId;
        this.price = price;
        this.duration = duration;
    }

    public CreateOfferRequest(String name, String createdBy, Long businessId, Float price, String duration) {
        super(name, createdBy);
        this.businessId = businessId;
        this.price = price;
        this.duration = duration;
    }
}
