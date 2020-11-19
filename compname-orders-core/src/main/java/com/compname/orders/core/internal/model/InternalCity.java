package com.compname.orders.core.internal.model;

import com.compname.orders.api.model.business.Business;
import com.compname.orders.api.model.city.City;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.common.Deletable;
import com.compname.orders.core.internal.common.InternalBasicEntity;
import com.compname.orders.core.internal.common.InternalIdEntity;
import com.compname.orders.core.internal.common.Updateable;

public interface InternalCity extends
        InternalIdEntity,
        ApiConvertible<City>,
        Deletable<InternalCity>,
        Updateable<InternalCity> {
    String getName();
    Integer getPostalCode();
}
