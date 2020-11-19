package com.compname.orders.api.message.response.city;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.model.city.City;
import com.compname.orders.api.model.city.CityFacade;
import com.compname.orders.utility.ResponseCode;

public class UpdateCityResponse extends ApiPayloadResponse<City> implements CityFacade {
    public UpdateCityResponse(ApiRequest request, ResponseCode responseCode, City payload) {
        super(request, responseCode, payload);
    }

    @Override
    public void setName(String name) {
        this.getPayload().setName(name);
    }

    @Override
    public void setPostalCode(Integer postalCode) {
        this.getPayload().setPostalCode(postalCode);
    }
}
