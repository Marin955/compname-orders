package com.compname.orders.core.persistence;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "term")
@SequenceGenerator(name = DbTerm.SEQUENCE_NAME, sequenceName = DbTerm.SEQUENCE_NAME, allocationSize = 1)
public class DbTerm {

    public static final String SEQUENCE_NAME = "s_term";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id", nullable = false)
    private DbService service;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private DbUser user;

    @Column(name = "from")
    private ZonedDateTime from;

    @Column(name = "to")
    private ZonedDateTime to;

    public DbTerm() { }

    public DbTerm(Long id) { this.id = id; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setService(DbService service) {
        this.service = service;
    }

    public void setUser(DbUser user) {
        this.user = user;
    }

    public void setFrom(ZonedDateTime from) {
        this.from = from;
    }

    public void setTo(ZonedDateTime to) {
        this.to = to;
    }

    public Long getId() {
        return id;
    }

    public DbService getService() {
        return service;
    }

    public DbUser getUser() {
        return user;
    }

    public ZonedDateTime getFrom() {
        return from;
    }

    public ZonedDateTime getTo() {
        return to;
    }
}
