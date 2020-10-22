package com.ithillel.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estate_agency")
@SequenceGenerator(name = "seq_name", sequenceName = "estate_agency_id_seq", allocationSize = 1)
public class EstateAgency extends CustomModel {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "EstateAgency_Realtor",
            joinColumns = {
                    @JoinColumn(name = "estateAgency_id"),
            },
            inverseJoinColumns = {@JoinColumn(name = "realtor_id")}
    )
    private List<Realtor> realtorList;

    @ManyToOne
    @JoinColumn(name = "district_id", columnDefinition = "id")
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
}
