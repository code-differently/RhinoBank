package com.stayready.repositories;

import com.stayready.domain.Deposit;
import org.springframework.data.repository.CrudRepository;

public interface DepositRepository extends CrudRepository<Deposit, Long>{
}