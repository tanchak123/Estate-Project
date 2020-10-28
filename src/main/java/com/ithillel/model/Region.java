package com.ithillel.model;

import javax.persistence.*;

@Entity
@Table(name = "region")
@SequenceGenerator(name = "seq_name", sequenceName = "region_id_seq", allocationSize = 1)
public class Region extends CustomModel {

    @OneToOne(mappedBy = "region", cascade = CascadeType.ALL)
    private Area oblast;

    public Region() {

    };

    public Area getOblast() {
        return oblast;
    }

    public void setOblast(Area oblast) {
        this.oblast = oblast;
    }
}
