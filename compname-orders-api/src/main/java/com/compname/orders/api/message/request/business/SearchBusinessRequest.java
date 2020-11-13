package com.compname.orders.api.message.request.business;

import com.compname.orders.api.message.request.ApiPaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SearchBusinessRequest extends ApiPaginationRequest {
    private Long oib;
    private String name;
    private String city;
}
