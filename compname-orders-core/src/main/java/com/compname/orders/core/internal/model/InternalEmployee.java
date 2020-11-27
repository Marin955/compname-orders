package com.compname.orders.core.internal.model;

import com.compname.orders.api.message.request.employee.UpdateEmployeeRequest;
import com.compname.orders.api.model.employee.Employee;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.common.Deletable;
import com.compname.orders.core.internal.common.InternalBasicEntity;
import com.compname.orders.core.internal.common.Updatable;

import java.util.List;

public interface InternalEmployee extends
        InternalBasicEntity,
        ApiConvertible<Employee>,
        Deletable<InternalEmployee>,
        Updatable<InternalEmployee, UpdateEmployeeRequest> {
    String getName();
    String getTitle();
    List<InternalOffer> getOffers();
    Long getBusinessId();
}
