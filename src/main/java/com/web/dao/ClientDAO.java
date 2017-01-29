package com.web.dao;

import com.web.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by JakubWitczak on 28.01.2017.
 */
@Repository
public interface ClientDAO extends JpaRepository<Client, Long> {
}
