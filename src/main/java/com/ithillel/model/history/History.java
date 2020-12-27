package com.ithillel.model.history;

import com.ithillel.enums.HistoryLevel;
import com.ithillel.enums.HistoryType;
import com.ithillel.model.Client;
import com.ithillel.utils.CreateTimeStampConverter;
import com.ithillel.utils.EnumTypePostgreSql;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;

@Component
@Entity
@Table(name = "History")
@SequenceGenerator(name = "seq_name", sequenceName = "history_id_seq", allocationSize = 1)
@NamedStoredProcedureQuery(
        name = "deleteHistoryByDate",
        procedureName = "delete_all_by_date",
        parameters = {
                @StoredProcedureParameter(type = Timestamp.class, mode = ParameterMode.IN),
        }
)
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_name")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "create_date")
    @Convert(converter = CreateTimeStampConverter.class)
    private Long createDate;

    @ManyToOne(cascade = {})
    @JoinTable(name = "client_history",
            joinColumns = {@JoinColumn(name = "history_id")},
            inverseJoinColumns = {@JoinColumn(name = "client_id")})
    private Client client;

    @Column(name = "history_level")
    @Enumerated(EnumType.ORDINAL)
    private HistoryLevel historyLevel;

    @Column(name = "history_type")
    @Enumerated(EnumType.STRING)
    private HistoryType historyType;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "history")
    private HistoryDetail historyDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long create_date) {
        this.createDate = create_date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public HistoryLevel getHistoryLevel() {
        return historyLevel;
    }

    public void setHistoryLevel(HistoryLevel historyLevel) {
        this.historyLevel = historyLevel;
    }

    public HistoryType getHistoryType() {
        return historyType;
    }

    public void setHistoryType(HistoryType historyType) {
        this.historyType = historyType;
    }

    public HistoryDetail getHistoryDetail() {
        return historyDetail;
    }

    public void setHistoryDetail(HistoryDetail historyDetail) {
        this.historyDetail = historyDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
