package com.compname.orders.api.message.request.term;

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
public class SearchTermRequest extends ApiPaginationRequest {
    private Long offerId;
    private Long accountId;
    private Long employeeId;
    private ZonedDateTime from;
    private ZonedDateTime to;

    public SearchTermRequest(Integer pageNumber, Integer pageSize, Long offerId, Long accountId, Long employeeId, ZonedDateTime from, ZonedDateTime to) {
        super(pageNumber, pageSize);
        this.offerId = offerId;
        this.accountId = accountId;
        this.employeeId = employeeId;
        this.from = from;
        this.to = to;
    }
}
