package com.compname.orders.core.internal.model;

import com.compname.orders.api.message.request.business.UpdateBusinessRequest;
import com.compname.orders.api.model.business.Address;
import com.compname.orders.api.model.business.Business;
import com.compname.orders.api.model.business.ContactInfo;
import com.compname.orders.api.model.business.Geolocation;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.common.Deletable;
import com.compname.orders.core.internal.common.InternalBasicEntity;
import com.compname.orders.core.internal.common.Updatable;

import java.util.List;
import java.util.Set;

public interface InternalBusiness extends
        InternalBasicEntity,
        ApiConvertible<Business>,
        Deletable<InternalBusiness>,
        Updatable<InternalBusiness, UpdateBusinessRequest> {

    Long getOib();
    Address getAddress();
    ContactInfo getContactInfo();
    Geolocation getGeolocation();
    String getMinInterval();
    Float getRating();
    Set<InternalOffer> getOffers();
    List<InternalEmployee> getEmployees();
}
