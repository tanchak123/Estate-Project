package com.ithillel.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "oblast")
@SequenceGenerator(name = "seq_name", sequenceName = "oblast_id_seq", allocationSize = 1)
public class Oblast extends CustomModel {

    public Oblast() {
    }

    @OneToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    Region region;

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }


    @OneToMany(mappedBy = "oblast", cascade = CascadeType.ALL)
    List<District> districts;

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
}
