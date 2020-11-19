package com.compname.orders.api.message.request.offer;

import com.compname.orders.api.message.request.ApiPaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateOfferRequest extends ApiPaginationRequest {
    private Long businessId;
    private String name;
    private Float price;
    private String duration;
}
