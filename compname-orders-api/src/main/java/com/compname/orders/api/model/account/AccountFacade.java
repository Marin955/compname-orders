package com.compname.orders.api.model.account;

public interface AccountFacade {
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setMail(String mail);
    void setPassword(String password);
    void setPhone(String phone);
    void setStrikes(Integer strikes);
}
