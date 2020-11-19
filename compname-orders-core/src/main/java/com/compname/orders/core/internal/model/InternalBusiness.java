package com.compname.orders.core.internal.model;

import com.compname.orders.api.model.business.Address;
import com.compname.orders.api.model.business.Business;
import com.compname.orders.api.model.business.ContactInfo;
import com.compname.orders.api.model.business.Geolocation;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.common.Deletable;
import com.compname.orders.core.internal.common.InternalBasicEntity;
import com.compname.orders.core.internal.common.Updateable;

public interface InternalBusiness extends
        InternalBasicEntity,
        ApiConvertible<Business>,
        Deletable<InternalBusiness>,
        Updateable<InternalBusiness> {

    Long getOib();
    Address getAddress();
    ContactInfo getContactInfo();
    Geolocation getGeolocation();
    String getMinInterval();

}
