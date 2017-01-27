package com.web.rest.controller;

import com.web.model.Beer;
import com.web.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by JakubWitczak on 26.01.2017.
 */
@RestController
@RequestMapping("/api/beers")
public class BeerRestController {

    @Autowired
    private BeerService beerService;

    @RequestMapping(method = RequestMethod.GET)
    List<Beer> findAll(){
        return beerService.getAllBeers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{beerId}")
    Beer findOne(@PathVariable("beerId") Long beerId){
        return beerService.findById(beerId);
    }

    @RequestMapping(method = RequestMethod.POST)
    void addBeer(@RequestBody Beer newBeer){
        beerService.addBeer(newBeer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{beerId}")
    void deleteBeer(@PathVariable("beerId") Long beerId){
        beerService.deleteBeer(beerId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{beerId}")
    void updateBeer(@PathVariable("beerId") Long beerId, @RequestBody Beer beer){
        beerService.updateBeer(beerId, beer);
    }
}
