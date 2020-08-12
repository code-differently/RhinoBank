package com.stayready.Repositories;

import com.stayready.Domain.Withdrawal;

import org.springframework.data.repository.CrudRepository;

public interface WithdrawalRepository extends CrudRepository<Withdrawal, Long>{
    
}