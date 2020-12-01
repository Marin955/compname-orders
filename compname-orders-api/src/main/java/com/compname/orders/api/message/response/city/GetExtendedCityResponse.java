package com.compname.orders.api.message.response.city;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.model.city.ExtendedCity;
import com.compname.orders.utility.ResponseCode;

public class GetExtendedCityResponse extends ApiPayloadResponse<ExtendedCity> {
    public GetExtendedCityResponse(ApiRequest request, ResponseCode responseCode, ExtendedCity payload) {
        super(request, responseCode, payload);
    }
}
