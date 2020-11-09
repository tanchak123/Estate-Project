package com.ithillel.model;

import com.ithillel.model.generic.CustomModel;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "city")
@SequenceGenerator(name = "seq_name", sequenceName = "city_id_seq", allocationSize = 1)
public class City extends CustomModel {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private District district;

    public City() {
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
