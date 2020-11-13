package com.compname.orders.api.message.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class ApiRequest {

    private Long providerId;
    private String channel;
    private String user;

}
