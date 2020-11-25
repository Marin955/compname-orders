package com.compname.orders.core.internal.model;

import com.compname.orders.api.message.request.account.UpdateAccountRequest;
import com.compname.orders.api.model.account.Account;
import com.compname.orders.api.model.term.Term;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.common.Deletable;
import com.compname.orders.core.internal.common.InternalIdEntity;
import com.compname.orders.core.internal.common.Updatable;

import java.time.ZonedDateTime;
import java.util.List;

public interface InternalAccount extends
        InternalIdEntity,
        ApiConvertible<Account>,
        Deletable<InternalAccount>,
        Updatable<InternalAccount, UpdateAccountRequest> {

    ZonedDateTime getCreated();
    String getFirstName();
    String getLastName();
    String getMail();
    String getPassword();
    String getPhone();
    Integer getStrikes();
    List<InternalTerm> getTerms();

}
