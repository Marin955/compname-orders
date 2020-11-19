package com.compname.orders.api.message.response.city;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPagedPayloadResponse;
import com.compname.orders.api.model.city.City;
import com.compname.orders.utility.ResponseCode;

import java.util.List;

public class SearchCityResponse extends ApiPagedPayloadResponse<City> {
    public SearchCityResponse(ApiRequest request, ResponseCode responseCode, List<City> payload, Integer pageNumber, Integer pageSize) {
        super(request, responseCode, payload, pageNumber, pageSize);
    }
}
