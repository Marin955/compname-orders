package com.compname.orders.api.message.request.account;

import com.compname.orders.api.message.request.ApiPaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchAccountRequest extends ApiPaginationRequest {

    private String firstName;
    private String lastName;
    private String phone;
    private Integer strikes;

}
