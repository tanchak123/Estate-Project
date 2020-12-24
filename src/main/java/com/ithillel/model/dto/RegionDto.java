package com.ithillel.model.dto;

import com.ithillel.model.Region;
import com.ithillel.model.dto.custom.CustomDto;

public class RegionDto extends CustomDto {

    private String area;

    public RegionDto(String name, Long id) {
        super(name, id);
    }
    public RegionDto() {
    }

    public void toModel(Region model) {
        model.setName(getName());
    }

    public void fromModel(Region model) {
        setId(model.getId());
        setName(model.getName());
        setArea(model.getArea().getName());
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
