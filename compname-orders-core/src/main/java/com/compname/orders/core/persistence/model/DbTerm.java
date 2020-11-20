package com.compname.orders.core.persistence.model;

import com.compname.orders.core.persistence.DbEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "term")
@SequenceGenerator(name = DbTerm.SEQUENCE_NAME, sequenceName = DbTerm.SEQUENCE_NAME, allocationSize = 1)
public class DbTerm extends DbEntity<Long> {

    public static final String SEQUENCE_NAME = "s_term";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "offer_id", nullable = false)
    private DbOffer offer;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private DbAccount account;

    @Column(name = "from")
    private ZonedDateTime from;

    @Column(name = "to")
    private ZonedDateTime to;

    public DbTerm(Long id) { this.id = id; }
}
