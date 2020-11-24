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

    //TODO created field
    private Long offerId;
    private Long accountId;
    private ZonedDateTime from;
    private ZonedDateTime to;

    public CreateTermRequest(Long id, Long offerId, Long accountId, ZonedDateTime from, ZonedDateTime to) {
        super(id);
        this.offerId = offerId;
        this.accountId = accountId;
        this.from = from;
        this.to = to;
    }
}
