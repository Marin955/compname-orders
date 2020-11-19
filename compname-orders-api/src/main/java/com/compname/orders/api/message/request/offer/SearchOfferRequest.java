package com.compname.orders.api.message.request.offer;

import com.compname.orders.api.message.request.ApiPaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SearchOfferRequest extends ApiPaginationRequest {
    private Long businessId;
    private String name;
}
