package com.ithillel.model;

import com.ithillel.model.customodel.CustomModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "estate_agency")
@SequenceGenerator(name = "seq_name", sequenceName = "estate_agency_id_seq", allocationSize = 1)
public class EstateAgency extends CustomModel {

    @ManyToMany()
    @JoinTable(
            name = "estate_agency_realtor",
            joinColumns = {
                    @JoinColumn(name = "estate_agency_id"),
            },
            inverseJoinColumns = {@JoinColumn(name = "realtor_id")}
    )
    private List<Realtor> realtorList = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "district_id")
    private District district;

    public List<Realtor> getRealtorList() {
        return realtorList;
    }

    public void setRealtorList(List<Realtor> realtorList) {
        this.realtorList = realtorList;
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
        EstateAgency that = (EstateAgency) o;
        return Objects.equals(realtorList, that.realtorList) &&
                Objects.equals(district, that.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(realtorList, district);
    }
}
