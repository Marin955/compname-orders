package com.compname.orders.core.persistence;

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
@Table(name = "user")
@SequenceGenerator(name = DbUser.SEQUENCE_NAME, sequenceName = DbUser.SEQUENCE_NAME, allocationSize = 1)
public class DbUser {

    public static final String SEQUENCE_NAME = "s_users";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "id")
    private Long id;

    @Column(name = "created")
    private ZonedDateTime created;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private Set<DbTerm> terms = new HashSet<>();

    @Column(name = "strikes")
    private Integer strikes;

    public DbUser(Long id) { this.id = id; }
}
