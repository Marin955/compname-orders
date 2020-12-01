package com.compname.orders.api.model.employee;

import com.compname.orders.api.model.ApiBasicEntity;
import com.compname.orders.api.model.offer.Offer;
import com.compname.orders.api.model.term.Term;
import com.compname.orders.api.model.workhour.WorkHour;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee extends ApiBasicEntity {

    private String title;
    private Long businessId;
    private Set<Offer> offers;
    private List<WorkHour> workHours;
    private Set<Term> terms;

    public Employee(Long id, String name, ZonedDateTime created, String createdBy, String title, Long businessId, Set<Offer> offers, List<WorkHour> workHours, Set<Term> terms) {
        super(id, name, created, createdBy);
        this.title = title;
        this.businessId = businessId;
        this.offers = offers;
        this.workHours = workHours;
        this.terms = terms;
    }

    public Employee(String name, ZonedDateTime created, String createdBy, String title, Long businessId, Set<Offer> offers, List<WorkHour> workHours, Set<Term> terms) {
        super(name, created, createdBy);
        this.title = title;
        this.businessId = businessId;
        this.offers = offers;
        this.workHours = workHours;
        this.terms = terms;
    }
}
