package com.stayready.repositories;

import com.stayready.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long>
{
}
