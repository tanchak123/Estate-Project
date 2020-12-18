package com.ithillel.model.customodel;

import com.ithillel.utils.CreateTimeStampConverter;
import com.ithillel.utils.UpdateTimeStampConverter;

import javax.persistence.*;

@MappedSuperclass
public class CustomModel implements GetId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_name")
    protected Long id;

    @Column(name = "update_date")
    @Convert(converter = UpdateTimeStampConverter.class)
    protected Long updateDate;

    @Column(name = "create_date", updatable = false)
    @Convert(converter = CreateTimeStampConverter.class)
    protected Long createDate;

//    @Embedded()
//    CustomDescription description;

    protected String name;

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomModel{" +
                "id=" + id +
                ", updateDate=" + updateDate +
                ", createDate=" + createDate +
                ", name='" + name + '\'' +
                '}';
    }
}
