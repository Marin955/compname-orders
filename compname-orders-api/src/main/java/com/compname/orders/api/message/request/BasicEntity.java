package com.compname.orders.api.message.request;

import java.time.ZonedDateTime;

public abstract class BasicEntity extends ApiIdRequest {

    private String name;
    private ZonedDateTime created;
    private String createdBy;

    public BasicEntity(String name, ZonedDateTime created, String createdBy) {
        this.name = name;
        this.created = created;
        this.createdBy = createdBy;
    }

    public BasicEntity(Long id, String name, ZonedDateTime created, String createdBy) {
        super(id);
        this.name = name;
        this.created = created;
        this.createdBy = createdBy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public String getCreatedBy() {
        return createdBy;
    }
}
