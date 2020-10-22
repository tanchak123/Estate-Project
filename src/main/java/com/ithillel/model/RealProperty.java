package com.ithillel.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "real_property")
@SequenceGenerator(name = "seq_name", sequenceName = "real_property_id_seq", allocationSize = 1)
public class RealProperty extends CustomModel {

    @ManyToMany
    @JoinTable(name = "realProperty_Realtor",
            joinColumns = @JoinColumn(name = "realtor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "real_property_id", referencedColumnName = "id")

    )
    private List<Realtor> realtors;

    public List<Realtor> getRealtors() {
        return realtors;
    }

    public void setRealtors(List<Realtor> realtors) {
        this.realtors = realtors;
    }
}
