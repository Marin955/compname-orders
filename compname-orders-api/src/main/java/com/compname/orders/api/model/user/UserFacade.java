package com.compname.orders.api.model.user;

public interface UserFacade {
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setMail(String mail);
    void setPassword(String password);
    void setPhone(String phone);
    void setStrikes(Integer strikes);
}
