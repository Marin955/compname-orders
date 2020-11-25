package com.compname.orders.api.model.account;

import com.compname.orders.api.model.ApiIdEntity;
import com.compname.orders.api.model.term.Term;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Account extends ApiIdEntity {
    private ZonedDateTime created;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private String phone;
    private Integer strikes;
    private List<Term> terms;

    public Account(
            Long id,
            ZonedDateTime created,
            String firstName,
            String lastName,
            String mail,
            String password,
            String phone,
            Integer strikes,
            List<Term> terms
    ) {
        super(id);
        this.created = created;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.strikes = strikes;
        this.terms = terms;
    }
}
