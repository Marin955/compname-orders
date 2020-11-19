package com.compname.orders.core.internal.model;

import com.compname.orders.api.model.offer.Offer;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.common.Deletable;
import com.compname.orders.core.internal.common.InternalBasicEntity;
import com.compname.orders.core.internal.common.Updateable;

public interface InternalOffer extends
        InternalBasicEntity,
        ApiConvertible<Offer>,
        Deletable<InternalOffer>,
        Updateable<InternalOffer> {

    Long getBusinessId();
    Float getPrice();
    String getDuration();

}
