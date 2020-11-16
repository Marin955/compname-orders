package com.compname.orders.api.model.term;

import java.time.ZonedDateTime;

public interface TermFacade {
    void setFrom(ZonedDateTime from);
    void setTo(ZonedDateTime to);
}
