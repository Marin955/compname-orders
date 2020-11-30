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
public class CreateWorkHourRequest extends ApiIdRequest {

    private Long employeeId;
    private ZonedDateTime from;
    private ZonedDateTime to;

    public CreateWorkHourRequest(Long id, Long employeeId, ZonedDateTime from, ZonedDateTime to) {
        super(id);
        this.employeeId = employeeId;
        this.from = from;
        this.to = to;
    }
}
