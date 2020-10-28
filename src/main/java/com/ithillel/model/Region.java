package com.ithillel.model;

import javax.persistence.*;

@Entity
@Table(name = "region")
@SequenceGenerator(name = "seq_name", sequenceName = "region_id_seq", allocationSize = 1)
public class Region extends CustomModel {

    @OneToOne(mappedBy = "region", cascade = CascadeType.ALL)
    private Area area;

    public Region() {

    };

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
