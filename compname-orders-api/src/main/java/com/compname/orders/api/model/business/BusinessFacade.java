package com.compname.orders.api.model.business;

public interface BusinessFacade {
    void setOib(Long oib);
    void setName(String name);
    void setCity(String city);
    void setAddress(String address);
    void setLongitude(Float longitude);
    void setLatitude(Float latitude);
    void setPhone(String phone);
    void setMail(String mail);
    void setWebsite(String website);
    void setRating(Float rating);
    void setMinInterval(String minInterval);
}
