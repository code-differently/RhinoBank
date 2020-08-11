package com.stayready.repositories;

import com.stayready.domains.Withdrawal;
import org.springframework.data.repository.CrudRepository;

public interface WithdrawalRepository extends CrudRepository<Withdrawal, Long> {
}
