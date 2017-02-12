package com.web.rest.controller;

import com.web.model.Beer;
import com.web.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


/**
 * Created by JakubWitczak on 26.01.2017.
 */
@RestController
@RequestMapping("/{login}/beers")
public class BeerRestController {

    @Autowired
    private BeerService beerService;

    @RequestMapping(method = RequestMethod.GET)
    Collection<Beer> readBeers(@PathVariable String login) {
        beerService.validateUser(login);
        return beerService.readBeers(login);
    }

    @RequestMapping(method = RequestMethod.POST)
    void add(@PathVariable String login, @RequestBody Beer newBeer) {
        beerService.validateUser(login);
        beerService.add(login, newBeer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{beerId}")
    void deleteBeer(@PathVariable String login, @PathVariable("beerId") Long beerId) {
        beerService.deleteBeer(login, beerId);
    }

//    @RequestMapping(method = RequestMethod.PUT, value = "/{beerId}")
//    void updateBeer(@PathVariable("beerId") Long beerId, @RequestBody Beer beer) {
//        beerService.updateBeer(beerId, beer);
//    }
}
