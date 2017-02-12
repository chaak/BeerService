package com.web.services.impl;

import com.web.dao.AccountDAO;
import com.web.dao.BeerDAO;
import com.web.exception.UserNotFoundException;
import com.web.model.Beer;
import com.web.services.BeerService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

/**
 * Created by JakubWitczak on 18.12.2016.
 */
@Service
public class DefaultBeerService implements BeerService {

    @Autowired
    private final BeerDAO beerDAO;

    @Autowired
    private final AccountDAO accountDAO;

    @Autowired
    public DefaultBeerService(BeerDAO beerDAO, AccountDAO accountDAO) {
        this.beerDAO = beerDAO;
        this.accountDAO = accountDAO;
    }

    @Override
    public Collection<Beer> readBeers(String login) {
        this.validateUser(login);
        return this.beerDAO.findByAccountLogin(login);
    }

    @Override
    public ResponseEntity<?> add(String login, Beer newBeer) {
        return this.accountDAO
                .findByLogin(login)
                .map(account -> {

                    Beer result = beerDAO.save(new Beer(newBeer.getAccount(), newBeer.getBrewery(), newBeer.getName(),
                                newBeer.getType(), newBeer.getIbu(), newBeer.getAlkPercentage(), newBeer.getPrice()));

                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .buildAndExpand(result.getAccount()).toUri();

                    return ResponseEntity.created(location).build();
                })
                .orElse(ResponseEntity.noContent().build());
       // beerDAO.saveAndFlush(newBeer);
    }

    @Override
    public void updateBeer(Long id, Beer beerToUpdate) {
    }

    @Override
    public void deleteBeer(String login, Long id) {
        this.validateUser(login);
        this.beerDAO.delete(id);
    }

    @Override
    public void validateUser(String login) {
        this.accountDAO.findByLogin(login).orElseThrow(
                () -> new UserNotFoundException(login));
    }
}
