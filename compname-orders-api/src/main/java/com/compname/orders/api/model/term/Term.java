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

    private Long serviceId;
    private Long userId;
    private ZonedDateTime from;
    private ZonedDateTime to;

    public Term(Long id, Long serviceId, Long userId, ZonedDateTime from, ZonedDateTime to) {
        super(id);
        this.serviceId = serviceId;
        this.userId = userId;
        this.from = from;
        this.to = to;
    }
}
