package fpt.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fpt.spring.model.Account;
import fpt.spring.repository.AccountRespository;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountRespository accountRespository;
	
	public List<Account> findAll() {
		return accountRespository.findAll();
	}
	
	public void delete(String username) {
		int id = 0;
		List<Account> list = findAll();
		for(Account account:list) {
			if(account.getUsername().equals(username)) {
				id = account.getId();
			}
		}
		accountRespository.delete(id);
	}
	
	public Account getAccountByUsername(String username) {
		int id = 0;
		List<Account> list = findAll();
		for(Account account:list) {
			if(account.getUsername().equals(username)) {
				id = account.getId();
			}
		}
		return accountRespository.findOne(id);
	}
	
	public void save(Account account) {
		accountRespository.save(account);
	}
}
