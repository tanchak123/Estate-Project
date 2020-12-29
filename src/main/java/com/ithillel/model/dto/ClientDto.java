package com.ithillel.model.dto;

public class ClientDto {

    private Long id;
    private String name;
    private String surname;
    private String login;
    private String role;

    public ClientDto(Long id, String name, String surname, String login, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
