package com.ithillel.model;

import com.ithillel.model.generic.CustomModel;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Objects;

@Component
@Entity
@Table(name = "region")
@SequenceGenerator(name = "seq_name", sequenceName = "region_id_seq", allocationSize = 1)
public class Region extends CustomModel {

    @OneToOne(mappedBy = "region", cascade = CascadeType.ALL)
    private Area area;

    public Region() {

    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(area, region.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area);
    }
}
