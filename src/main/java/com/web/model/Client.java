package com.web.model;

import javax.persistence.*;

/**
 * Created by JakubWitczak on 26.01.2017.
 */
@Entity(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private Long id;
    private String name;
    private String surName;

    public Client(String name, String surName, String login, String password) {
        this.name = name;
        this.surName = surName;
        this.login = login;
        this.password = password;
    }

    public Client(){
        
    }

    private String login;
    private String password;

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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
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
}
