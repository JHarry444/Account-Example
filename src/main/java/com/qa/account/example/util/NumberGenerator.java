package com.qa.account.example.util;

import java.util.Random;

public class NumberGenerator {

	private int length;
	private char[] type = { 'a', 'b', 'c' };

	public NumberGenerator(int length) {
		this.length = length;
	}

	public String genNumber() {
		Random rand = new Random();
		char accountType = type[rand.nextInt(3)];
		String output = "" + accountType;
		for (int i = 0; i < this.length; i++) {
			output += rand.nextInt(10);
		}
		return output;
	}
}
