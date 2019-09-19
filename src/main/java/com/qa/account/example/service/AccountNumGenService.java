package com.qa.account.example.service;

import org.springframework.stereotype.Service;

import com.qa.account.example.util.NumberGenerator;

@Service
public class AccountNumGenService {

	private NumberGenerator numGen;

	public AccountNumGenService(NumberGenerator numGen) {
		this.numGen = numGen;
	}

	public String genNumber() {
		return this.numGen.genNumber();
	}

}
