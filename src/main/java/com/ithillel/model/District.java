package com.ithillel.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "district")
@SequenceGenerator(name = "seq_name", sequenceName = "district_id_seq", allocationSize = 1)
public class District extends CustomModel {

    @ManyToOne
    @JoinColumn(name = "oblast_id", referencedColumnName = "id")
    private Oblast oblast;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    private List<City> cities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "district")
    private List<EstateAgency> estateAgency;

    public Oblast getOblast() {
        return oblast;
    }

    public void setOblast(Oblast oblast) {
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
