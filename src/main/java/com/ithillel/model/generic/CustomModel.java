package com.ithillel.model.generic;

import java.util.Calendar;
import javax.persistence.*;

import com.ithillel.model.description.CustomDescription;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class CustomModel implements GetId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_name")
    private Integer id;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Calendar calendar;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Calendar calendarC;

    @Embedded()
    CustomDescription description;

    private String name;

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Calendar getCalendarC() {
        return calendarC;
    }

    public void setCalendarC(Calendar calendarC) {
        this.calendarC = calendarC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomDescription getDescription() {
        return description;
    }

    public void setDescription(CustomDescription description) {
        this.description = description;
    }
}
