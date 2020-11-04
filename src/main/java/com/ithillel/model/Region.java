package com.ithillel.model;

import com.ithillel.model.generic.CustomModel;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

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
}
