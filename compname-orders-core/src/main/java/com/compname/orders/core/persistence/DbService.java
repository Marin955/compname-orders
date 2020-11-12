package com.compname.orders.core.persistence;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "service")
@SequenceGenerator(name = DbService.SEQUENCE_NAME, sequenceName = DbService.SEQUENCE_NAME, allocationSize = 1)
public class DbService {

    public static final String SEQUENCE_NAME = "s_service";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "business_id", nullable = false)
    private DbBusiness business;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private String duration;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "service")
    private Set<DbTerm> terms = new HashSet<>();

    public DbService() {}

    public DbService(Long id) { this.id = id; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBusiness(DbBusiness business) {
        this.business = business;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setTerms(Set<DbTerm> terms) {
        this.terms = terms;
    }

    public Long getId() {
        return id;
    }

    public DbBusiness getBusiness() {
        return business;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public Set<DbTerm> getTerms() {
        return terms;
    }
}
