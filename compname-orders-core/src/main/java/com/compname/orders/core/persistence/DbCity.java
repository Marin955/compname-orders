package com.compname.orders.core.persistence;

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
public class DbCity {

    public static final String SEQUENCE_NAME = "s_city";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "postal_code")
    private String postalCode;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "city")
    private Set<DbBusiness> businesses = new HashSet<>();

    public DbCity(Long id) { this.id = id; }
}