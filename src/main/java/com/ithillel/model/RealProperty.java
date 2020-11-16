package com.ithillel.model;

import com.ithillel.model.generic.CustomModel;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "real_property")
@SequenceGenerator(name = "seq_name", sequenceName = "real_property_id_seq", allocationSize = 1)
public class RealProperty extends CustomModel {

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "real_property_Realtor",
            joinColumns = @JoinColumn(name = "realtor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "real_property_id", referencedColumnName = "id")

    )
    private List<Realtor> realtorList;

    public List<Realtor> getRealtorList() {
        return realtorList;
    }

    public void setRealtorList(List<Realtor> realtors) {
        this.realtorList = realtors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealProperty that = (RealProperty) o;
        return Objects.equals(realtorList, that.realtorList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(realtorList);
    }
}
