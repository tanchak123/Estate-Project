package com.ithillel.model;

import com.ithillel.model.generic.CustomModel;
import java.util.List;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "realtor")
@SequenceGenerator(name = "seq_name", sequenceName = "realtor_id_seq", allocationSize = 1)
public class Realtor extends CustomModel {

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "realtorList")
    private List<EstateAgency> estateAgency;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "realtors")
    private List<RealProperty> propertyList;

    @Column(name = "surname")
    private String surName;

    @Column(name = "experience_in_years")
    private int experience;

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

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
