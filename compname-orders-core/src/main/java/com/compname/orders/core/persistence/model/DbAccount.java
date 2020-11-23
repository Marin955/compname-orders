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
@Table(name = "account")
@SequenceGenerator(name = DbAccount.SEQUENCE_NAME, sequenceName = DbAccount.SEQUENCE_NAME, allocationSize = 1)
public class DbAccount extends DbEntity<Long> {

    public static final String SEQUENCE_NAME = "s_accounts";

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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "account")
    private Set<DbTerm> terms = new HashSet<>();

    @Column(name = "strikes")
    private Integer strikes;

    public DbAccount(Long id) { this.id = id; }

    public enum DbAccountMapping
    {
        ID("id", "id"),
        FIRST_NAME("firstName", "first_name"),
        LAST_NAME("lastName", "last_name");

        private final String field;
        private final String column;

        DbAccountMapping(String field, String column)
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
