package com.compname.orders.api.model.workhour;

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
public class WorkHour extends ApiIdEntity {
    private Long employeeId;
    private ZonedDateTime from;
    private ZonedDateTime to;

    public WorkHour(Long id, Long employeeId, ZonedDateTime from, ZonedDateTime to) {
        super(id);
        this.employeeId = employeeId;
        this.from = from;
        this.to = to;
    }
}
