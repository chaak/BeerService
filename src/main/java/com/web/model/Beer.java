package com.web.model;

import javax.persistence.*;

/**
 * Created by JakubWitczak on 18.12.2016.
 */
@Entity(name = "beers")
public class Beer {
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

    public Beer(Long Id, String brewery, String name, String type, int IBU, double alkPercentage, double price) {
        this.Id = Id;
        this.brewery = brewery;
        this.name = name;
        this.type = type;
        this.IBU = IBU;
        this.alkPercentage = alkPercentage;
        this.price = price;
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
