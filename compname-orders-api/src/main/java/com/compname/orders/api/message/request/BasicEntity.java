package com.compname.orders.api.message.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@NoArgsConstructor
@Setter
@Getter
public abstract class BasicEntity extends ApiIdRequest {

    private String name;
    @JsonIgnore
    private ZonedDateTime created;
    private String createdBy;

    public BasicEntity(Long id, String name, String createdBy) {
        super(id);
        this.name = name;
        this.created = ZonedDateTime.now();
        this.createdBy = createdBy;
    }

    public BasicEntity(String name, String createdBy) {
        this.name = name;
        this.created = ZonedDateTime.now();
        this.createdBy = createdBy;
    }
}
