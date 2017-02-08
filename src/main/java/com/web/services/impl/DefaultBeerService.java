package com.web.services.impl;

import com.web.dao.AccountDAO;
import com.web.dao.BeerDAO;
import com.web.exception.UserNotFoundException;
import com.web.model.Beer;
import com.web.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void addBeer(Beer newBeer) {

    }

    @Override
    public void updateBeer(Long id, Beer beerToUpdate) {

    }

    @Override
    public void deleteBeer(Long id) {

    }

    @Override
    public void validateUser(String login) {
        this.accountDAO.findByLogin(login).orElseThrow(
                () -> new UserNotFoundException(login));
    }
}
