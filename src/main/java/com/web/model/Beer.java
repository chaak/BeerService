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
    private Account account;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "beer_id")
    private Long Id;

    private String brewery;
    private String name;
    private String type;
    private int IBU;
    private double alkPercentage;
    private double price;

    public Beer(Account account,String brewery, String name, String type, int IBU, double alkPercentage, double price) {
        this.account = account;
        this.brewery = brewery;
        this.name = name;
        this.type = type;
        this.IBU = IBU;
        this.alkPercentage = alkPercentage;
        this.price = price;
    }

    public Beer() {

    }

    public Account getAccount() {
        return account;
    }

    public Long getId() {
        return Id;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIBU() {
        return IBU;
    }

    public void setIBU(int IBU) {
        this.IBU = IBU;
    }

    public double getAlkPercentage() {
        return alkPercentage;
    }

    public void setAlkPercentage(double alkPercentage) {
        this.alkPercentage = alkPercentage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
