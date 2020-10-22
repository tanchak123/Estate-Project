package com.ithillel.model;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "city")
@SequenceGenerator(name = "seq_name", sequenceName = "city_id_seq", allocationSize = 1)
public class City extends CustomModel {

    public City() {
    }

    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    District district;

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
