package com.web.rest.controller;

import com.web.dao.AccountDAO;
import com.web.dao.BeerDAO;
import com.web.exception.UserNotFoundException;
import com.web.model.Beer;
import com.web.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;

/**
 * Created by JakubWitczak on 26.01.2017.
 */
@RestController
@RequestMapping("/{userId}/beers")
public class BeerRestController {

    private final BeerDAO beerDAO;
    private final AccountDAO accountDAO;

    @Autowired
    public BeerRestController(BeerDAO beerDAO, AccountDAO accountDAO) {
        this.beerDAO = beerDAO;
        this.accountDAO = accountDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Beer> readBeers(@PathVariable String userId) {
        this.validateUser(userId);
        return this.beerDAO.findByAccountLogin(userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{beerId}")
    Beer readBeer(@PathVariable String userId, @PathVariable Long beerId) {
        this.validateUser(userId);
        return this.beerDAO.findOne(beerId);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    ResponseEntity<?> addBeer(@PathVariable String userId, @RequestBody Beer input) {
//        this.validateUser(userId);
//
//        return this.accountDAO
//                .findByLogin(userId)
//                .map(account -> {
//                    Beer result = beerDAO.save(new Beer(account,
//                            input.uri, input.description));
//
//                    URI location = ServletUriComponentsBuilder
//                            .fromCurrentRequest().path("/{id}")
//                            .buildAndExpand(result.getId()).toUri();
//
//                    return ResponseEntity.created(location).build();
//                })
//                .orElse(ResponseEntity.noContent().build());
//
//    }

    private void validateUser(String userId) {
        this.accountDAO.findByLogin(userId).orElseThrow(
                () -> new UserNotFoundException(userId));
    }

//    @Autowired
//    private BeerService beerService;
//
//    @RequestMapping(method = RequestMethod.GET)
//    List<Beer> findAll() {
//        return beerService.getAllBeers();
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/{beerId}")
//    Beer findOne(@PathVariable("beerId") Long beerId) {
//        return beerService.findById(beerId);
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    void addBeer(@RequestBody Beer newBeer) {
//        beerService.addBeer(newBeer);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "/{beerId}")
//    void deleteBeer(@PathVariable("beerId") Long beerId) {
//        beerService.deleteBeer(beerId);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = "/{beerId}")
//    void updateBeer(@PathVariable("beerId") Long beerId, @RequestBody Beer beer) {
//        beerService.updateBeer(beerId, beer);
//    }
}
