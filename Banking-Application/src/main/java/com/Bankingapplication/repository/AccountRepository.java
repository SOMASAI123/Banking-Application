package com.Bankingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bankingapplication.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
