package com.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by JakubWitczak on 18.12.2016.
 */
@Entity(name = "beers")
public class Beer {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Account account;

    @Id
    @GeneratedValue
    @Column(name = "beer_id")
    private Long id;

    public Beer() {

    }

    private String brewery;
    private String name;
    private String type;
    private double ibu;
    private double alkPercentage;
    private double price;

    public Beer(Account account, String brewery, String name, String type, double ibu, double alkPercentage, double price) {
        this.account = account;
        this.brewery = brewery;
        this.name = name;
        this.type = type;
        this.ibu = ibu;
        this.alkPercentage = alkPercentage;
        this.price = price;
    }

    public Account getAccount() {
        return account;
    }

    public Long getId() {
        return id;
    }

    public String getBrewery() {
        return brewery;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getIbu() {
        return ibu;
    }

    public double getAlkPercentage() {
        return alkPercentage;
    }

    public double getPrice() {
        return price;
    }

}
