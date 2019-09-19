package com.qa.account.example.service;

import org.springframework.stereotype.Service;

@Service
public class PrizeGenService {

	public double genPrize(String accountNum) {
		if (accountNum.toLowerCase().startsWith("b")) {
			if (accountNum.length() == 7) {
				return 50;
			} else if (accountNum.length() == 9) {
				return 500;
			} else if (accountNum.length() == 10) {
				return 5000;
			}
		} else if (accountNum.toLowerCase().startsWith("c")) {
			if (accountNum.length() == 7) {
				return 100;
			} else if (accountNum.length() == 9) {
				return 750;
			} else if (accountNum.length() == 10) {
				return 10000;
			}
		}
		return 0;
	}
}
