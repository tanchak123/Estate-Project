package com.ithillel.model;

import com.ithillel.model.generic.CustomModel;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(district, city.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(district);
    }
}
