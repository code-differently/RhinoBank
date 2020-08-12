package com.stayready.Repositories;

import com.stayready.Domain.Bill;

import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Long>{
    
}