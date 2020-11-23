package com.ithillel.model.history;

import com.ithillel.model.Client;
import com.ithillel.utils.CreateTimeStampConverter;
import jdk.jfr.BooleanFlag;
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

    @Column(name = "create_date")
    @Convert(converter = CreateTimeStampConverter.class)
    private Long create_date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @Column(name = "history_level")
    private String history_level;

    @Column(name = "history_type")
    private String history_type;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "history")
    private HistoryDetail historyDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Long create_date) {
        this.create_date = create_date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getHistory_level() {
        return history_level;
    }

    public void setHistory_level(String history_level) {
        this.history_level = history_level;
    }

    public String getHistory_type() {
        return history_type;
    }

    public void setHistory_type(String history_type) {
        this.history_type = history_type;
    }

    public HistoryDetail getHistoryDetail() {
        return historyDetail;
    }

    public void setHistoryDetail(HistoryDetail historyDetail) {
        this.historyDetail = historyDetail;
    }
}
