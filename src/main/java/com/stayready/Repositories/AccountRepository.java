package com.stayready.Repositories;

import com.stayready.Domain.Account;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long>{
    
}