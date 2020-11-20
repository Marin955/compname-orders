package com.compname.orders.core.internal.common;

import com.compname.orders.api.message.request.ApiIdRequest;

public interface Updatable<T extends InternalEntity, R extends ApiIdRequest> {
    T update(R request);
}
