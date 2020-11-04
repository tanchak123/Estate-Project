package com.ithillel.model;

import com.ithillel.model.generic.CustomModel;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "real_property")
@SequenceGenerator(name = "seq_name", sequenceName = "real_property_id_seq", allocationSize = 1)
public class RealProperty extends CustomModel {

    @ManyToMany
    @JoinTable(name = "real_property_Realtor",
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
