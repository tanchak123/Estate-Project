package com.ithillel.model.dto;

public class ClientDto {

    private Long id;
    private String name;
    private String surname;
    private String login;

    public ClientDto(Long id, String name, String surName, String login) {
        this.id = id;
        this.name = name;
        this.surname = surName;
        this.login = login;
    }

    public ClientDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
}
