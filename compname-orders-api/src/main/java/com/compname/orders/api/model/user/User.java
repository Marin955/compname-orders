package com.compname.orders.api.model.user;

import com.compname.orders.api.model.ApiIdEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
@Setter
public class User extends ApiIdEntity {
    private ZonedDateTime created;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private String phone;
    private Integer strikes;

    public User(Long id, ZonedDateTime created, String firstName, String lastName, String mail, String password, String phone, Integer strikes) {
        super(id);
        this.created = created;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.strikes = strikes;
    }
}
