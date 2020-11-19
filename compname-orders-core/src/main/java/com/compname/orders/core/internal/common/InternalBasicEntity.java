package com.compname.orders.core.internal.common;

import java.time.ZonedDateTime;

public interface InternalBasicEntity extends InternalIdEntity {
    String getName();
    ZonedDateTime getCreated();
    String getCreatedBy();
}
