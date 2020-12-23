package com.ithillel.model.dto;

import com.ithillel.model.Realtor;
import com.ithillel.model.customodel.CustomModel;
import com.ithillel.model.dto.custom.CustomDto;

public class RealtorDto extends CustomDto {

    private String surname;
    private Integer experience;

    public RealtorDto(String name, Long id) {
        super(name, id);
    }

    public RealtorDto() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void dtoToModel(Realtor model) {
        model.setName(getName());
        model.setSurName(getSurname());
        model.setExperience(getExperience());
    }

    public void modelToDto(Realtor model) {
        setId(model.getId());
        setName(model.getName());
        setExperience(model.getExperience());
        setSurname(model.getSurName());
    }
}
