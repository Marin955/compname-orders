package com.compname.orders.core.internal.model;

import com.compname.orders.api.message.request.term.UpdateTermRequest;
import com.compname.orders.api.model.term.Term;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.common.Deletable;
import com.compname.orders.core.internal.common.InternalIdEntity;
import com.compname.orders.core.internal.common.Updatable;

import java.time.ZonedDateTime;

public interface InternalTerm extends
        InternalIdEntity,
        ApiConvertible<Term>,
        Deletable<InternalTerm>,
        Updatable<InternalTerm, UpdateTermRequest> {

    Long getServiceId();
    Long getAccountId();
    ZonedDateTime getFrom();
    ZonedDateTime getTo();

}
