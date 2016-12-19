package com.web.services;

import com.web.model.Beer;

import java.util.List;

/**
 * Created by JakubWitczak on 18.12.2016.
 */
public interface BeerService {
    List<Beer> getAllBeers();

    Beer findById(Long id);

    void addBeer(Beer newBeer);

    void updateBeer(Long id, Beer beerToUpdate);

    void deleteBeer(Long id);
}
