package com.compname.orders.api.model;

public class ContactInfo {

    private String phone;
    private String mail;
    private String website;

    public ContactInfo(String phone, String mail, String website) {
        this.phone = phone;
        this.mail = mail;
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getWebsite() {
        return website;
    }
}
