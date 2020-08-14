package com.stayready.repositories;

import com.stayready.domain.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long>
{
    @Query(value = "SELECT a.*" +
        "FROM Customer c, Account a" +
            "WHERE c.CUSTOMER_ID = ?1", nativeQuery = true)
    public Iterable<Account> findAllAccountsForCustomer(Long pollId);
}
