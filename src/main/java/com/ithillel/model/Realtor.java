package com.ithillel.model;

import com.ithillel.model.generic.CustomModel;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "realtor")
@SequenceGenerator(name = "seq_name", sequenceName = "realtor_id_seq", allocationSize = 1)
public class Realtor extends CustomModel {

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "realtorList")
    private List<EstateAgency> estateAgency = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "realtors")
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

    public List<EstateAgency> getEstateAgency() {
        return estateAgency;
    }

    public void setEstateAgency(List<EstateAgency> estateAgency) {
        this.estateAgency = estateAgency;
    }

    public List<RealProperty> getRealPropertyList() {
        return realPropertyList;
    }

    public void setRealPropertyList(List<RealProperty> propertyList) {
        this.realPropertyList = propertyList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Realtor realtor = (Realtor) o;

        if (experience != realtor.experience) return false;
        if (estateAgency != null ? !estateAgency.equals(realtor.estateAgency) : realtor.estateAgency != null)
            return false;
        if (realPropertyList != null ? !realPropertyList.equals(realtor.realPropertyList) : realtor.realPropertyList != null)
            return false;
        return surName != null ? surName.equals(realtor.surName) : realtor.surName == null;
    }

    @Override
    public int hashCode() {
        int result = estateAgency != null ? estateAgency.hashCode() : 0;
        result = 31 * result + (realPropertyList != null ? realPropertyList.hashCode() : 0);
        result = 31 * result + (surName != null ? surName.hashCode() : 0);
        result = 31 * result + experience;
        return result;
    }
}
