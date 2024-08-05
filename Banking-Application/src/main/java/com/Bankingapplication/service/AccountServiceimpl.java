package com.Bankingapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bankingapplication.entities.Account;
import com.Bankingapplication.repository.AccountRepository;

@Service
public class AccountServiceimpl implements AccountService{
   
	@Autowired
	AccountRepository repo;
	
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		Account acc=repo.save(account);
		
		return acc;
	}

	@Override
	public Account getAccountDetailsbyAccountnumber(int accountNumber) {
		// TODO Auto-generated method stub
	Optional<Account> account=	repo.findById(accountNumber);
	if(account.isEmpty())
	{
		throw new RuntimeException("account is not found");
	}
	Account acc=account.get();
		return acc;
	}

	@Override
	public List<Account> getAllAccountsDetails() {
		// TODO Auto-generated method stub
		
		List<Account> account=repo.findAll();
		return account;
	}

	@Override
	public Account withdrawAmount(int accountNumber, int amount) {
		// TODO Auto-generated method stub
		
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty())
		{
			throw new RuntimeException("account is not found");
		}
		Account acc=account.get();
		
		int totalbalance=acc.getAccount_balance()-amount;
	    acc.setAccount_balance(totalbalance);
	    repo.save(acc);
		
		return acc;
	}

	@Override
	public void closeAccount(int accountNumber) {
		// TODO Auto-generated method stub
		repo.deleteById(accountNumber);
		
	}

	@Override
	public Account depositAmount(int accountNumber, int amount) {
		// TODO Auto-generated method stub
		
		Optional<Account> account=repo.findById(accountNumber);
		
		if(account.isEmpty())
		{
			throw new RuntimeException("account is not found");
		}
		
		Account acc=account.get();
		int totalbalance=acc.getAccount_balance()+amount;
		acc.setAccount_balance(totalbalance);
		repo.save(acc);
		return acc;
	}
	
	

}
