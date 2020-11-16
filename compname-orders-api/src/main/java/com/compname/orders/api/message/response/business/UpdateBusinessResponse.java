package com.compname.orders.api.message.response.business;

import com.compname.orders.api.message.request.business.UpdateBusinessRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.message.response.ResponseCode;
import com.compname.orders.api.model.business.Business;
import com.compname.orders.api.model.business.BusinessFacade;

public class UpdateBusinessResponse extends ApiPayloadResponse<Business> implements BusinessFacade {

    public UpdateBusinessResponse(UpdateBusinessRequest request, ResponseCode responseCode, Business payload) {
        super(request, responseCode, payload);
    }

    @Override
    public void setOib(Long oib) {
        this.getPayload().setOib(oib);
    }

    @Override
    public void setName(String name) {
        this.getPayload().setName(name);
    }

    @Override
    public void setCity(String city) {
        this.getPayload().getAddress().setCity(city);
    }

    @Override
    public void setAddress(String address) {
        this.getPayload().getAddress().setAddress(address);
    }

    @Override
    public void setLongitude(Float longitude) {
        this.getPayload().getGeolocation().setLongitude(longitude);
    }

    @Override
    public void setLatitude(Float latitude) {
        this.getPayload().getGeolocation().setLatitude(latitude);
    }

    @Override
    public void setPhone(String phone) {
        this.getPayload().getContactInfo().setPhone(phone);
    }

    @Override
    public void setMail(String mail) {
        this.getPayload().getContactInfo().setMail(mail);
    }

    @Override
    public void setWebsite(String website) {
        this.getPayload().getContactInfo().setWebsite(website);
    }

    @Override
    public void setRating(Float rating) {
        this.getPayload().setRating(rating);
    }

    @Override
    public void setMinInterval(String minInterval) {
        this.getPayload().setMinInterval(minInterval);
    }
}