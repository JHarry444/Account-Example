package com.qa.account.example.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.account.example.persistence.domain.Account;
import com.qa.account.example.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	private AccountService service;

	public AccountController(AccountService service) {
		this.service = service;
	}

	@PostMapping(value = "/register", consumes = "application/json")
	public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
		return this.service.addAccount(account);
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Account>> getAccounts() {
		return service.getAccounts();
	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {
		return this.service.getAccount(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteAccount(@PathVariable("id") Long id) {
		return this.service.deleteAccount(id);
	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateAccount(@RequestBody Account account, @PathParam("id") Long id) {
		return this.service.updateAccount(account, id);
	}
}
