package com.compname.orders.api.message.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class ApiRequest {

    @JsonIgnore
    private Long providerId;
    @JsonIgnore
    private String channel;
    @JsonIgnore
    private String user;

}
