package com.ithillel.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "realtor")
@SequenceGenerator(name = "seq_name", sequenceName = "realtor_id_seq", allocationSize = 1)
public class Realtor extends CustomModel {

    @ManyToMany(mappedBy = "realtorList")
    private List<EstateAgency> estateAgency;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "realtors")
    private List<RealProperty> propertyList;

    public List<EstateAgency> getEstateAgency() {
        return estateAgency;
    }

    public void setEstateAgency(List<EstateAgency> estateAgency) {
        this.estateAgency = estateAgency;
    }

    public List<RealProperty> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<RealProperty> propertyList) {
        this.propertyList = propertyList;
    }
}
