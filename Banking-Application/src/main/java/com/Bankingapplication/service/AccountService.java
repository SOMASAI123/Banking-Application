package com.Bankingapplication.service;

import java.util.List;

import com.Bankingapplication.entities.Account;

public interface AccountService {
	
	public Account createAccount(Account account);
	
	public Account getAccountDetailsbyAccountnumber(int accountNumber);
	
    public List<Account> getAllAccountsDetails();
    
    public Account depositAmount(int accountNumber,int amount);
    
    public Account withdrawAmount(int accountNumber,int amount);
    
    public void closeAccount(int accountNumber);
    
    
}
