package com.compname.orders.core.internal.common;

public interface Deletable<T extends InternalEntity> {
    T delete();
}
