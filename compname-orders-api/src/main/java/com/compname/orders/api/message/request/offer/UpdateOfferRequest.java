package com.compname.orders.api.message.request.offer;

import com.compname.orders.api.message.request.ApiIdRequest;
import com.compname.orders.api.message.request.ApiPaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateOfferRequest extends ApiIdRequest {
    private String name;
    private Float price;
    private String duration;

    public UpdateOfferRequest(Long id, String name, Float price, String duration) {
        super(id);
        this.name = name;
        this.price = price;
        this.duration = duration;
    }
}
