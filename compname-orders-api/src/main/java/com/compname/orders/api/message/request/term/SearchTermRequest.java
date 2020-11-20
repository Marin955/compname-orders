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
    private ZonedDateTime from;
    private ZonedDateTime to;
}
