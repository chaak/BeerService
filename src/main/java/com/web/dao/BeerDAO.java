package com.web.dao;

import com.web.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by JakubWitczak on 18.12.2016.
 */
@Repository
public interface BeerDAO extends JpaRepository<Beer, Long> {
    Beer findByBeerName(String beerName);
}
