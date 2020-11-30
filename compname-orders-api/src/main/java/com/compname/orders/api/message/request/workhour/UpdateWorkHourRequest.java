package com.compname.orders.api.message.request.workhour;

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
public class UpdateWorkHourRequest extends ApiIdRequest {
    private ZonedDateTime from;
    private ZonedDateTime to;

    public UpdateWorkHourRequest(Long id, ZonedDateTime from, ZonedDateTime to) {
        super(id);
        this.from = from;
        this.to = to;
    }
}
