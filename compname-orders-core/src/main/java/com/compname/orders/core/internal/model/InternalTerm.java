package com.compname.orders.core.internal.model;

import com.compname.orders.api.model.term.Term;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.common.Deletable;
import com.compname.orders.core.internal.common.InternalIdEntity;
import com.compname.orders.core.internal.common.Updateable;

import java.time.ZonedDateTime;

public interface InternalTerm extends
        InternalIdEntity,
        ApiConvertible<Term>,
        Deletable<InternalTerm>,
        Updateable<InternalBusiness> {

    Long getServiceId();
    Long getUserId();
    ZonedDateTime getFrom();
    ZonedDateTime getTo();

}
