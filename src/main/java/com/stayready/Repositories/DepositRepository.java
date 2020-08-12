package com.stayready.Repositories;

import com.stayready.Domain.Deposit;

import org.springframework.data.repository.CrudRepository;

public interface DepositRepository extends CrudRepository<Deposit, Long>{
    
}