package com.compname.orders.api.model.offer;

public interface OfferFacade {
    void setBusinessId(Long businessId);
    void setName(String name);
    void setPrice(Float price);
    void setDuration(String duration);
}
