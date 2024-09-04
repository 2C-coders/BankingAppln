package com.mani.BankingAppln.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mani.BankingAppln.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
