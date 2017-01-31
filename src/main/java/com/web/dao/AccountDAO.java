package com.web.dao;

import com.web.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by JakubWitczak on 28.01.2017.
 */
@Repository
public interface AccountDAO extends JpaRepository<Account, Long> {
    Optional<Account> findByLogin(String login);
}
