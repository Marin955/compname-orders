package com.compname.orders.api.message.request.term;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreateTermRequest {

    private Long id;
    private Long serviceId;
    private Long userId;
    private ZonedDateTime from;
    private ZonedDateTime to;

    public CreateTermRequest(Long serviceId, Long userId, ZonedDateTime from, ZonedDateTime to) {
        this.serviceId = serviceId;
        this.userId = userId;
        this.from = from;
        this.to = to;
    }
}
