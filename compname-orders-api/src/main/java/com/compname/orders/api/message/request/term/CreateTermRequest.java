package com.compname.orders.api.message.request.term;

import com.compname.orders.api.message.request.ApiIdRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreateTermRequest extends ApiIdRequest {

    private Long serviceId;
    private Long userId;
    private ZonedDateTime from;
    private ZonedDateTime to;

    public CreateTermRequest(Long id, Long serviceId, Long userId, ZonedDateTime from, ZonedDateTime to) {
        super(id);
        this.serviceId = serviceId;
        this.userId = userId;
        this.from = from;
        this.to = to;
    }
}