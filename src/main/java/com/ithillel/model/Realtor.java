package com.ithillel.model;

import com.ithillel.model.customodel.CustomModel;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "realtor")
@SequenceGenerator(name = "seq_name", sequenceName = "realtor_id_seq", allocationSize = 1)
public class Realtor extends CustomModel {

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "realtorList")
    private List<EstateAgency> estateAgencyList = new ArrayList<>();

    @ManyToMany(cascade = {}, mappedBy = "realtorList")
    private List<RealProperty> realPropertyList = new ArrayList<>();

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

    public List<EstateAgency> getEstateAgencyList() {
        return estateAgencyList;
    }

    public void setEstateAgencyList(List<EstateAgency> estateAgencyList) {
        this.estateAgencyList = estateAgencyList;
    }

    public List<RealProperty> getRealPropertyList() {
        return realPropertyList;
    }

    public void setRealPropertyList(List<RealProperty> propertyList) {
        this.realPropertyList  = propertyList;
    }

    public void addRealPropertyList(List<RealProperty> propertyList) {
        this.realPropertyList.addAll(propertyList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Realtor realtor = (Realtor) o;

        if (experience != realtor.experience) return false;
        if (estateAgencyList != null ? !estateAgencyList.equals(realtor.estateAgencyList) : realtor.estateAgencyList != null)
            return false;
        if (realPropertyList != null ? !realPropertyList.equals(realtor.realPropertyList) : realtor.realPropertyList != null)
            return false;
        return surName != null ? surName.equals(realtor.surName) : realtor.surName == null;
    }

    @Override
    public int hashCode() {
        int result = estateAgencyList != null ? estateAgencyList.hashCode() : 0;
        result = 31 * result + (realPropertyList != null ? realPropertyList.hashCode() : 0);
        result = 31 * result + (surName != null ? surName.hashCode() : 0);
        result = 31 * result + experience;
        return result;
    }
}
