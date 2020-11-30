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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.ZonedDateTime;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "work_hours")
@SequenceGenerator(name = DbWorkHour.SEQUENCE_NAME, sequenceName = DbWorkHour.SEQUENCE_NAME, allocationSize = 1)
public class DbWorkHour extends DbEntity<Long> {

    public static final String SEQUENCE_NAME = "s_work_hour";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    private DbEmployee employee;

    @Column(name = "from_time")
    private ZonedDateTime from;

    @Column(name = "to_time")
    private ZonedDateTime to;

    public DbWorkHour(Long id) { this.id = id; }

    public enum DbWorkHourMapping
    {
        ID("id", "id"),
        EMPLOYEE("employee", "employee_id"),
        FROM("from", "from_time"),
        TO("to", "to_time");

        private final String field;
        private final String column;

        DbWorkHourMapping(String field, String column)
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
