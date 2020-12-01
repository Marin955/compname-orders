package com.compname.orders.core.internal.model;

import com.compname.orders.api.message.request.city.UpdateCityRequest;
import com.compname.orders.api.model.city.City;
import com.compname.orders.api.model.city.ExtendedCity;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.common.Deletable;
import com.compname.orders.core.internal.common.InternalIdEntity;
import com.compname.orders.core.internal.common.Updatable;

import java.util.List;

public interface InternalCity extends
        InternalIdEntity,
        ApiConvertible<City>,
        Deletable<InternalCity>,
        Updatable<InternalCity, UpdateCityRequest> {
    String getName();
    Integer getPostalCode();
    List<InternalBusiness> getBusinesses();
    ExtendedCity toExtendedApi();
}
