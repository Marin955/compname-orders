package com.compname.orders.core.persistence.model;

import com.compname.orders.core.persistence.DbEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "city")
@SequenceGenerator(name = DbCity.SEQUENCE_NAME, sequenceName = DbCity.SEQUENCE_NAME, allocationSize = 1)
public class DbCity extends DbEntity<Long> {

    public static final String SEQUENCE_NAME = "s_city";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "postal_code")
    private Integer postalCode;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "city")
    private Set<DbBusiness> businesses = new HashSet<>();

    public DbCity(Long id) { this.id = id; }

    public enum DbCityMapping
    {
        ID("id", "id"),
        NAME("name", "name"),
        POSTAL_CODE("postalCode", "postal_code");

        private final String field;
        private final String column;

        DbCityMapping(String field, String column)
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