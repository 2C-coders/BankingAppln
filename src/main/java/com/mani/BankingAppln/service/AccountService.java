package com.mani.BankingAppln.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mani.BankingAppln.entity.Account;
import com.mani.BankingAppln.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository acntRepo;
	
	
	public Account createAccount(Account account) {
		return acntRepo.save(account);
	}
	
	public Optional<Account> getAccount(Long id){
		return acntRepo.findById(id);
	}
	
	public Account deposit(Long id,double amount) {
		Account account = getAccount(id).orElseThrow(()->new RuntimeException("Account not found"));
		account.setBalance(account.getBalance()+amount);
		return acntRepo.save(account);
	}
	
	
	public  Account withdraw(Long id,double amount) {
		Account account = getAccount(id).orElseThrow(()->new RuntimeException("Account not found"));
		if(account.getBalance()<amount) {
			throw new RuntimeException("Insufficient funds");
			
		}
		account.setBalance(account.getBalance()-amount );
		return acntRepo.save(account);
	}

}
