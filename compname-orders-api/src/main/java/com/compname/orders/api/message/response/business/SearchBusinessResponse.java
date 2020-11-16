package com.compname.orders.api.message.response.business;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPagedPayloadResponse;
import com.compname.orders.api.message.response.ResponseCode;
import com.compname.orders.api.model.business.Business;

import java.util.List;

public class SearchBusinessResponse extends ApiPagedPayloadResponse<Business> {
    public SearchBusinessResponse(ApiRequest request, ResponseCode responseCode, List<Business> payload, Integer pageNumber, Integer pageSize) {
        super(request, responseCode, payload, pageNumber, pageSize);
    }
}
