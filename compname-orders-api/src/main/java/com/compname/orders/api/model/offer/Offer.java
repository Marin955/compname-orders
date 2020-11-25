package com.compname.orders.api.model.offer;

import com.compname.orders.api.model.ApiBasicEntity;
import com.compname.orders.api.model.term.Term;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Offer extends ApiBasicEntity {
    private Long businessId;
    private Float price;
    private String duration;
    private List<Term> terms;

    public Offer(Long id, String name, ZonedDateTime created, String createdBy, Long businessId, Float price, String duration, List<Term> terms) {
        super(id, name, created, createdBy);
        this.businessId = businessId;
        this.price = price;
        this.duration = duration;
        this.terms = terms;
    }

    public Offer(String name, ZonedDateTime created, String createdBy, Long businessId, Float price, String duration, List<Term> terms) {
        super(name, created, createdBy);
        this.businessId = businessId;
        this.price = price;
        this.duration = duration;
        this.terms = terms;
    }
}
