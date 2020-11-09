package com.ithillel.model;

import com.ithillel.model.generic.CustomModel;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "district")
@SequenceGenerator(name = "seq_name", sequenceName = "district_id_seq", allocationSize = 1)
public class District extends CustomModel {

    @ManyToOne
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    private Area area;

    @OneToMany(mappedBy = "district", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<City> cities;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "district")
    private List<EstateAgency> estateAgency;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
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
