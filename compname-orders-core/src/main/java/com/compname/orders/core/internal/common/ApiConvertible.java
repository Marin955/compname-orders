package com.compname.orders.core.internal.common;

import com.compname.orders.api.model.ApiEntity;

public interface ApiConvertible<T extends ApiEntity> {
    T toApi();
}