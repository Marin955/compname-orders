package com.compname.orders.api.message.request.service;

import com.compname.orders.api.message.request.ApiPaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SearchServiceRequest extends ApiPaginationRequest {
    private Long id;
    private Long businessId;
    private String name;
}
