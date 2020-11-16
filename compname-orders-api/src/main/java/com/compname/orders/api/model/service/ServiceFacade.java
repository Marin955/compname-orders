package com.compname.orders.api.model.service;

public interface ServiceFacade {
    void setBusinessId(Long businessId);
    void setName(String name);
    void setPrice(Float price);
    void setDuration(String duration);
}
