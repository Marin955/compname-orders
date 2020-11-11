package com.compname.orders.core.persistence;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "business")
@SequenceGenerator(name = DbBusiness.SEQUENCE_NAME, sequenceName = DbBusiness.SEQUENCE_NAME, allocationSize = 1)

public class DbBusiness {

    public static final String SEQUENCE_NAME = "s_business";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "id")
    private Long id;

    @Column(name = "oib")
    private Long oib;

    @Column(name = "name")
    private String name;

    @Column(name = "created")
    private ZonedDateTime created;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private Integer postalCode;

    @Column(name = "address")
    private String address;

    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "website")
    private String website;

    @Column(name = "rating")
    private Float rating;

    // to be continued

    public DbBusiness() {
    }

    public DbBusiness(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOib(Long oib) {
        this.oib = oib;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public Long getOib() {
        return oib;
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getCity() {
        return city;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public String getAddress() {
        return address;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Float getLatitude() {
        return latitude;
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

    public Float getRating() {
        return rating;
    }
}
