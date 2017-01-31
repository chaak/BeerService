package com.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JakubWitczak on 26.01.2017.
 */
@Entity(name = "accounts")
public class Account {

    @OneToMany(mappedBy = "account")
    private Set<Beer> beers = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Long id;

    @JsonIgnore
    private String login;
    private String password;

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Account(){//for JPA

    }

    public Set<Beer> getBeers(){
        return beers;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }


}
