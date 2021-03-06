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

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIbu(double ibu) {
        this.ibu = ibu;
    }

    public void setAlkPercentage(double alkPercentage) {
        this.alkPercentage = alkPercentage;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
