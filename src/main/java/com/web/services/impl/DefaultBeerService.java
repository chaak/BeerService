package com.web.services.impl;

import com.web.dao.BeerDAO;
import com.web.model.Beer;
import com.web.services.BeerService;

import java.util.List;

/**
 * Created by JakubWitczak on 18.12.2016.
 */
public class DefaultBeerService implements BeerService {
    BeerDAO beerDAO;

    @Override
    public List<Beer> getAllBeers() {
        return null;
    }

    @Override
    public Beer findById(Long id) {
        return beerDAO.findOne(id);
    }

    @Override
    public void addBeer(Beer newBeer) {
        beerDAO.saveAndFlush(newBeer);
    }

    @Override
    public void updateBeer(Long id, Beer beerToUpdate) {
        Beer beer = beerDAO.findOne(id);
        beer.setType(beerToUpdate.getType());
        beer.setAlkPercentage(beerToUpdate.getAlkPercentage());
        beer.setName(beerToUpdate.getName());
        beer.setBrewery(beerToUpdate.getBrewery());
        beer.setIBU(beerToUpdate.getIBU());
        beer.setPrice(beer.getPrice());
        beerDAO.saveAndFlush(beer);
    }

    @Override
    public void deleteBeer(Long id) {
        beerDAO.delete(id);
    }
}
