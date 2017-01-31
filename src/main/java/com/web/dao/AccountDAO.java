package com.web.dao;

import com.web.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by JakubWitczak on 28.01.2017.
 */
@Repository
public interface AccountDAO extends JpaRepository<Account, Long> {
}
