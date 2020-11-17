package com.compname.orders.api.message.response.service;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPagedPayloadResponse;
import com.compname.orders.utility.ResponseCode;
import com.compname.orders.api.model.service.Service;

import java.util.List;

public class SearchServiceResponse extends ApiPagedPayloadResponse<Service> {
    public SearchServiceResponse(ApiRequest request, ResponseCode responseCode, List<Service> payload, Integer pageNumber, Integer pageSize) {
        super(request, responseCode, payload, pageNumber, pageSize);
    }
}
