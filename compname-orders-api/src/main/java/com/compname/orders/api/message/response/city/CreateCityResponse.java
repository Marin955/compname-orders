package com.compname.orders.api.message.response.city;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.model.city.City;
import com.compname.orders.utility.ResponseCode;


public class CreateCityResponse extends ApiPayloadResponse<City> {
    public CreateCityResponse(ApiRequest request, ResponseCode responseCode, City payload) {
        super(request, responseCode, payload);
    }
}
