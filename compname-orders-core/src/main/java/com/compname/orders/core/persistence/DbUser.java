package com.compname.orders.core.persistence;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "user")
@SequenceGenerator(name = DbBusiness.SEQUENCE_NAME, sequenceName = DbBusiness.SEQUENCE_NAME, allocationSize = 1)
public class DbUser {

    public static final String SEQUENCE_NAME = "s_user";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "id")
    private Long id;

    @Column(name = "created")
    private ZonedDateTime created;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "strikes")
    private Integer strikes;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStrikes(Integer strikes) {
        this.strikes = strikes;
    }

    public Long getId() {
        return id;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getStrikes() {
        return strikes;
    }
}
