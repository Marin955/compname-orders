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
@Table(name = "business")
@SequenceGenerator(name = DbBusiness.SEQUENCE_NAME, sequenceName = DbBusiness.SEQUENCE_NAME, allocationSize = 1)

public class DbBusiness extends DbEntity<Long> {

    public static final String SEQUENCE_NAME = "s_business";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "id")
    private Long id;

    @Column(name = "oib")
    private Long oib;

    @Column(name = "name")
    private String name;

    @Column(name = "created")
    private ZonedDateTime created;

    @Column(name = "created_by")
    private String createdBy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", nullable = false)
    private DbCity city;

    @Column(name = "address")
    private String address;

    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "website")
    private String website;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "min_interval")
    private String minInterval;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "business")
    private Set<DbOffer> offers = new HashSet<>();

    public DbBusiness(Long id) {
        this.id = id;
    }

    /**
     * The enum DbBusiness mapping.
     */
    public enum DbBusinessMapping
    {

        ID("id", "id"),
        NAME("name", "name"),
        CITY_ID("city", "city_id"),
        OIB("oib", "oib");

        private final String field;
        private final String column;

        DbBusinessMapping(String field, String column)
        {
            this.field = field;
            this.column = column;
        }

        public String getField()
        {
            return this.field;
        }

        public String getColumn()
        {
            return this.column;
        }

        @Override
        public String toString()
        {
            return String.format("%s::[field=%s, column=%s]", name(), getField(), getColumn());
        }
    }
}
