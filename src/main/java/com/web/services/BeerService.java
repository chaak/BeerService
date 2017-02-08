package com.web.services;

import com.web.model.Beer;
import java.util.Collection;

/**
 * Created by JakubWitczak on 18.12.2016.
 */
public interface BeerService {
    Collection<Beer> readBeers(String login);

    void addBeer(Beer newBeer);

    void updateBeer(Long id, Beer beerToUpdate);

    void deleteBeer(Long id);

    void validateUser(String login);
}
