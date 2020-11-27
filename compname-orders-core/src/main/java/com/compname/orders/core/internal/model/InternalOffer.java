package com.compname.orders.core.internal.model;

import com.compname.orders.api.message.request.offer.UpdateOfferRequest;
import com.compname.orders.api.model.offer.Offer;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.common.Deletable;
import com.compname.orders.core.internal.common.InternalBasicEntity;
import com.compname.orders.core.internal.common.Updatable;

import java.time.Duration;
import java.util.List;

public interface InternalOffer extends
        InternalBasicEntity,
        ApiConvertible<Offer>,
        Deletable<InternalOffer>,
        Updatable<InternalOffer, UpdateOfferRequest> {

    Long getBusinessId();
    Float getPrice();
    Duration getDuration();
    List<InternalTerm> getTerms();

}
