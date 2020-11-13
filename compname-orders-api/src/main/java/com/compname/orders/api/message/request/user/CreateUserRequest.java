package com.compname.orders.api.message.request.user;

import com.compname.orders.api.message.request.ApiIdRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@NoArgsConstructor
@Getter
@Setter
public class CreateUserRequest extends ApiIdRequest {

    private ZonedDateTime created;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private String phone;
    private Integer strikes;

    public CreateUserRequest(Long id, String firstName, String lastName, String mail, String password, String phone) {
        super(id);
        this.created = ZonedDateTime.now();
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.strikes = 0;
    }

    public CreateUserRequest(String firstName, String lastName, String mail, String password, String phone) {
        this.created = ZonedDateTime.now();
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.strikes = 0;
    }
}
