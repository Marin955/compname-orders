package com.compname.orders.api.message.request.user;

import com.compname.orders.api.message.request.ApiPaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchUserRequest extends ApiPaginationRequest {

    private String firstName;
    private String lastName;
    private String phone;
    private Integer strikes;

}
