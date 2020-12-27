package com.ithillel.model.dto;

import com.ithillel.model.history.History;
import com.ithillel.model.history.HistoryDetail;

public class HistoryDetailsDto extends HistoryDto {
    private Long detailId;
    private String detailName;
    private String value;

    public HistoryDetailsDto(String name, Long id) {
        super(name, id);
    }

    public HistoryDetailsDto() {
    }

    @Override
    public void toModel(History model) {
        super.toModel(model);
        HistoryDetail historyDetail = model.getHistoryDetail();
        historyDetail.setValue(getValue());
        historyDetail.setName(getHistoryType());
    }

    @Override
    public void fromModel(History model) {
        super.fromModel(model);
        HistoryDetail historyDetail = model.getHistoryDetail();
        setDetailId(historyDetail.getId());
        setDetailName(historyDetail.getName());
        setValue(historyDetail.getValue());
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HistoryDetailsDto{" +
                "detailId=" + detailId +
                ", detailName='" + detailName + '\'' +
                ", value='" + value + '\'' +
                ", historyLevel='" + historyLevel + '\'' +
                ", historyType='" + historyType + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
