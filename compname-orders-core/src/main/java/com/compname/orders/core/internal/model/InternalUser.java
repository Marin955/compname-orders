package com.compname.orders.core.internal.model;

import com.compname.orders.api.model.user.User;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.common.Deletable;
import com.compname.orders.core.internal.common.InternalIdEntity;
import com.compname.orders.core.internal.common.Updateable;

import java.time.ZonedDateTime;

public interface InternalUser extends
        InternalIdEntity,
        ApiConvertible<User>,
        Deletable<InternalUser>,
        Updateable<InternalBusiness> {

    ZonedDateTime getCreated();
    String getFirstName();
    String getLastName();
    String getMail();
    String getPassword();
    String getPhone();
    Integer getStrikes();

}
