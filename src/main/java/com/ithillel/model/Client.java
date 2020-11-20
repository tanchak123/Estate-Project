package com.ithillel.model;

import com.ithillel.model.generic.CustomModel;
import com.ithillel.model.history.History;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Table(name = "client")
@SequenceGenerator(name = "seq_name", sequenceName = "client_id_seq", allocationSize = 1)
public class Client extends CustomModel {

    @Column(name = "surname")
    private String surname;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "client")
    private List<History> historyList = new ArrayList<>();

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<History> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
    }

    public void addHistoryList(List<History> historyList) {
        this.historyList.addAll(historyList);
    }

    @Override
    public String toString() {
        return "Client{" +
                "surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", updateDate=" + updateDate +
                ", createDate=" + createDate +
                ", name='" + name + '\'' +
                '}';
    }
}
