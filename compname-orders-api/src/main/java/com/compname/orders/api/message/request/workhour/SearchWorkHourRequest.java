package com.compname.orders.api.message.request.workhour;

import com.compname.orders.api.message.request.ApiPaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchWorkHourRequest extends ApiPaginationRequest {

    private Long employeeId;
    private ZonedDateTime from;
    private ZonedDateTime to;

    public SearchWorkHourRequest(Integer pageNumber, Integer pageSize, Long employeeId, ZonedDateTime from, ZonedDateTime to) {
        super(pageNumber, pageSize);
        this.employeeId = employeeId;
        this.from = from;
        this.to = to;
    }
}
