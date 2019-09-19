package com.qa.account.example.persistence.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.account.example.persistence.domain.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

	Set<Account> findByFirstName(String firstName);

	Set<Account> findByLastName(String lastName);

	Set<Account> findByFirstNameAndLastName(String firstName, String lastName);

}
