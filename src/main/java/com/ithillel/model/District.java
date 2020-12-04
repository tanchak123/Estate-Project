package com.ithillel.model;

import com.ithillel.model.generic.CustomModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    private Area area;

    @OneToMany(mappedBy = "district", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<City> cityList = new ArrayList<>();

    @OneToMany(mappedBy = "district")
    private List<EstateAgency> estateAgencyList = new ArrayList<>();

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cities) {
        this.cityList = cities;
    }

    public List<EstateAgency> getEstateAgencyList() {
        return estateAgencyList;
    }

    public void setEstateAgencyList(List<EstateAgency> estateAgency) {
        this.estateAgencyList = estateAgency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Objects.equals(area, district.area) &&
                Objects.equals(cityList, district.cityList) &&
                Objects.equals(estateAgencyList, district.estateAgencyList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, cityList, estateAgencyList);
    }
}
