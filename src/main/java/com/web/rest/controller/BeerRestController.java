package com.web.rest.controller;

import com.web.model.Beer;
import com.web.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
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
