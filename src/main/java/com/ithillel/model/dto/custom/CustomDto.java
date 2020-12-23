package com.ithillel.model.dto.custom;

import com.ithillel.model.Realtor;
import com.ithillel.model.customodel.CustomModel;

public class CustomDto {
    private String name;
    private Long id;

    public CustomDto(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void dtoToModel(CustomModel model) {
        model.setName(getName());
    }

    public void modelToDto(Realtor realtor) {
        setId(realtor.getId());
        setName(realtor.getName());
    }

    public CustomDto() {

    }
}
