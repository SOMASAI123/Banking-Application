package com.Bankingapplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bankingapplication.entities.Account;
import com.Bankingapplication.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@PostMapping("/create")
    public Account createAccount(@RequestBody Account accoount)
    {  
	  Account account=	service.createAccount(accoount);
		
    	return account;
    }
	
	@GetMapping("/{accountNumber}")
	public Account getAccountbyAccountNumber(@PathVariable int accountNumber)
	{
		Account account=service.getAccountDetailsbyAccountnumber(accountNumber);
		
		return account;
	}
	
	@GetMapping("/getall")
	public List<Account> getAllaccount()
	{
		List<Account> acc=service.getAllAccountsDetails();
		return acc;
	}
	
	@PutMapping("/deposit/{accountNumber}/{amount}")
	public Account depositAccount( @PathVariable int accountNumber, @PathVariable int  amount)
	{
	      Account account=service.depositAmount(accountNumber, amount);
	      return account;
	}
	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public Account withdrawAmount(@PathVariable int accountNumber, @PathVariable  int amount)
	{
		Account account=service.withdrawAmount(accountNumber, amount);
		return account;
	}
	
	@DeleteMapping("/close/{accountNumber}")
	public void cloaseAccount(@PathVariable int accountNumber)
	{
	    service.closeAccount(accountNumber);
	}
	
}
