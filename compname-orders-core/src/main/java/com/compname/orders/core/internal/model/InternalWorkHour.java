package com.compname.orders.core.internal.model;

import com.compname.orders.api.message.request.workhour.UpdateWorkHourRequest;
import com.compname.orders.api.model.workhour.WorkHour;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.common.Deletable;
import com.compname.orders.core.internal.common.InternalIdEntity;
import com.compname.orders.core.internal.common.Updatable;

import java.time.ZonedDateTime;

public interface InternalWorkHour extends
        InternalIdEntity,
        ApiConvertible<WorkHour>,
        Deletable<InternalWorkHour>,
        Updatable<InternalWorkHour, UpdateWorkHourRequest> {
    Long getEmployeeId();
    ZonedDateTime getFrom();
    ZonedDateTime getTo();
}
