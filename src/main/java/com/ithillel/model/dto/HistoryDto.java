package com.ithillel.model.dto;

import com.ithillel.model.Realtor;
import com.ithillel.model.customodel.CustomModel;
import com.ithillel.model.dto.custom.CustomDto;
import com.ithillel.model.history.History;


public class HistoryDto extends CustomDto {

    protected String historyLevel;
    protected String historyType;

    public HistoryDto(String name, Long id) {
        super(name, id);
    }

    public HistoryDto() {

    }

    public void toModel(History model) {
        model.setName(getName());
        model.setHistoryLevel(model.getHistoryLevel());
        model.setHistoryType(model.getHistoryType());
    }


    public void fromModel(History model) {
        setId(model.getId());
        setName(model.getName());
        setHistoryLevel(model.getHistoryLevel().name());
        setHistoryType(model.getHistoryType().name());
    }

    public String getHistoryLevel() {
        return historyLevel;
    }

    public void setHistoryLevel(String historyLevel) {
        this.historyLevel = historyLevel;
    }

    public String getHistoryType() {
        return historyType;
    }

    public void setHistoryType(String historyType) {
        this.historyType = historyType;
    }

    @Override
    public String toString() {
        return "HistoryDto{" +
                "historyLevel='" + historyLevel + '\'' +
                ", historyType='" + historyType + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
