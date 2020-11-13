package com.ithillel.model;

import com.ithillel.model.generic.CustomModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "area")
@SequenceGenerator(name = "seq_name", sequenceName = "area_id_seq", allocationSize = 1)
public class Area extends CustomModel {

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Region region;

    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL)
    private List<District> districts = new ArrayList<>();

    public Area() {
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(region, area.region) &&
                Objects.equals(districts, area.districts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, districts);
    }
}
