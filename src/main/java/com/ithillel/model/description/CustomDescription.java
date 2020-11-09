package com.ithillel.model.description;

import com.ithillel.model.generic.CustomModel;

import javax.persistence.*;

@Embeddable
public class CustomDescription {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
