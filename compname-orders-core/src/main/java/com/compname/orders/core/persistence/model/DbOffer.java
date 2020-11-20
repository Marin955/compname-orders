package com.compname.orders.core.persistence.model;

import com.compname.orders.core.persistence.DbEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "offer")
@SequenceGenerator(name = DbOffer.SEQUENCE_NAME, sequenceName = DbOffer.SEQUENCE_NAME, allocationSize = 1)
public class DbOffer extends DbEntity<Long> {

    public static final String SEQUENCE_NAME = "s_offer";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "business_id", nullable = false)
    private DbBusiness business;

    @Column(name = "name")
    private String name;

    @Column(name = "created")
    private ZonedDateTime created;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "price")
    private Float price;

    @Column(name = "duration")
    private String duration;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "offer")
    private Set<DbTerm> terms = new HashSet<>();

    public DbOffer(Long id) { this.id = id; }
}
