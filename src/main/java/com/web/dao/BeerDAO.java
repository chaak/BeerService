package com.web.dao;

import com.web.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by JakubWitczak on 18.12.2016.
 */
@Repository
public interface BeerDAO extends JpaRepository<Beer, Long> {
    Collection<Beer> findByAccountLogin(String login);
}
