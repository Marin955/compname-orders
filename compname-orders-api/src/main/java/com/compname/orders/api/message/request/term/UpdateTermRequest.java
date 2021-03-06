package com.compname.orders.api.message.request.term;

import com.compname.orders.api.message.request.ApiIdRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateTermRequest extends ApiIdRequest {
    private ZonedDateTime from;
    private ZonedDateTime to;

    public UpdateTermRequest(Long id, ZonedDateTime from, ZonedDateTime to) {
        super(id);
        this.from = from;
        this.to = to;
    }
}
