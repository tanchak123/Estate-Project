package com.ithillel.model.history;

import com.ithillel.model.Client;
import com.ithillel.utils.CreateTimeStampConverter;
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
    private String historyLevel;

    @Column(name = "history_type")
    private String historyType;

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

    public String getHistoryLevel() {
        return historyLevel;
    }

    public void setHistoryLevel(String history_level) {
        this.historyLevel = history_level;
    }

    public String getHistoryType() {
        return historyType;
    }

    public void setHistoryType(String history_type) {
        this.historyType = history_type;
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
