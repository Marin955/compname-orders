package com.compname.orders.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class ApiBasicEntity extends ApiIdEntity {

    private String name;
    private ZonedDateTime created;
    private String createdBy;

    public ApiBasicEntity(Long id, String name, ZonedDateTime created, String createdBy) {
        super(id);
        this.name = name;
        this.created = created;
        this.createdBy = createdBy;
    }
}
