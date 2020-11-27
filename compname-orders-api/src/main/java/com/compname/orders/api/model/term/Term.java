package com.compname.orders.api.model.term;

import com.compname.orders.api.model.ApiIdEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Term extends ApiIdEntity {

    private ZonedDateTime created;
    private Long offerId;
    private Long accountId;
    private Long employeeId;
    private ZonedDateTime from;
    private ZonedDateTime to;

    public Term(Long id, ZonedDateTime created, Long offerId, Long accountId, Long employeeId, ZonedDateTime from, ZonedDateTime to) {
        super(id);
        this.created = created;
        this.offerId = offerId;
        this.accountId = accountId;
        this.employeeId = employeeId;
        this.from = from;
        this.to = to;
    }
}
