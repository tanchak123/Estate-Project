package com.ithillel.model;

import com.ithillel.model.generic.CustomModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "district")
@SequenceGenerator(name = "seq_name", sequenceName = "district_id_seq", allocationSize = 1)
public class District extends CustomModel {

    @ManyToOne
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    private Area oblast;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    private List<City> cities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "district")
    private List<EstateAgency> estateAgency;

    public Area getOblast() {
        return oblast;
    }

    public void setOblast(Area oblast) {
        this.oblast = oblast;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<EstateAgency> getEstateAgency() {
        return estateAgency;
    }

    public void setEstateAgency(List<EstateAgency> estateAgency) {
        this.estateAgency = estateAgency;
    }
}
