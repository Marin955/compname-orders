package com.compname.orders.core.persistence.model;

import com.compname.orders.core.persistence.DbEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "employee")
@SequenceGenerator(name = DbEmployee.SEQUENCE_NAME, sequenceName = DbEmployee.SEQUENCE_NAME, allocationSize = 1)
public class DbEmployee extends DbEntity<Long> {

    public static final String SEQUENCE_NAME = "s_employee";

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

    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "employee")
    private Set<DbTerm> terms = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "employee_offer_mapping",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "offer_id"))
    private Set<DbOffer> offers = new HashSet<>();

    public DbEmployee(Long id) { this.id = id; }

    public enum DbEmployeeMapping
    {
        ID("id", "id"),
        BUSINESS("business", "business_id"),
        NAME("name", "name"),
        OFFERS("offers", "offer_id");

        private final String field;
        private final String column;

        DbEmployeeMapping(String field, String column)
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

