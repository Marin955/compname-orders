package com.compname.orders.api.message.response.city;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPagedPayloadResponse;
import com.compname.orders.api.model.city.ExtendedCity;
import com.compname.orders.utility.ResponseCode;

import java.util.List;

public class SearchExtendedCityResponse extends ApiPagedPayloadResponse<ExtendedCity> {
    public SearchExtendedCityResponse(ApiRequest request, ResponseCode responseCode, List<ExtendedCity> payload, Integer pageNumber, Integer pageSize) {
        super(request, responseCode, payload, pageNumber, pageSize);
    }
}
