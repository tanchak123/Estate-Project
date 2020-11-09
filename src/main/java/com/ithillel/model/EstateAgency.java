package com.ithillel.model;

import com.ithillel.model.generic.CustomModel;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "estate_agency")
@SequenceGenerator(name = "seq_name", sequenceName = "estate_agency_id_seq", allocationSize = 1)
public class EstateAgency extends CustomModel {

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "estate_agency_realtor",
            joinColumns = {
                    @JoinColumn(name = "estate_agency_id"),
            },
            inverseJoinColumns = {@JoinColumn(name = "realtor_id")}
    )
    private List<Realtor> realtorList;

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
}
