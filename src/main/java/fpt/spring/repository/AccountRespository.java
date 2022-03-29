package fpt.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fpt.spring.model.Account;

public interface AccountRespository extends JpaRepository<Account, Integer>{

}
