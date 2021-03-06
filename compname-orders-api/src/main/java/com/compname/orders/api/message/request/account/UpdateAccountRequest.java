package com.compname.orders.api.message.request.account;

import com.compname.orders.api.message.request.ApiIdRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateAccountRequest extends ApiIdRequest {

    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private String phone;
    private Integer strikes;

    public UpdateAccountRequest(Long id, String firstName, String lastName, String mail, String password, String phone, Integer strikes) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.strikes = strikes;
    }
}
