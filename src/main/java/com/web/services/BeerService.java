package com.web.services;

import com.web.model.Beer;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

/**
 * Created by JakubWitczak on 18.12.2016.
 */
public interface BeerService {
    Collection<Beer> readBeers(String login);

    ResponseEntity<?> add(String login, Beer newBeer);

    void updateBeer(String login, Long id, Beer beer);

    void deleteBeer(String login, Long id);

    void validateUser(String login);
}
