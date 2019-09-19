package com.qa.account.example.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.account.example.persistence.domain.Account;
import com.qa.account.example.persistence.repo.AccountRepo;

@RunWith(SpringRunner.class)
public class AccountServiceUnitTest {

	@InjectMocks
	private AccountService service;

	@Mock
	private AccountRepo repo;

	@Mock
	private AccountNumGenService numGen;

	@Mock
	private PrizeGenService prizeGen;

	private final Account MOCK_ACCOUNT = new Account("a", "b", "c", 44.94);

	private final String ACC_NUM = "a123456";

	private final double PRIZE = 44.94;

	private final Account MOCK_ACCOUNT_2 = new Account(null, null, ACC_NUM, PRIZE);

	private final ResponseEntity<Account> RESPONSE_1 = ResponseEntity.ok(MOCK_ACCOUNT_2);

	@Test
	public void testGetAccounts() {
		List<Account> mockList = new ArrayList<>();
		mockList.add(MOCK_ACCOUNT);
		Mockito.when(repo.findAll()).thenReturn(mockList);

		assertEquals(mockList, this.service.getAccounts());

		Mockito.verify(this.repo, times(1)).findAll();
	}

	@Test
	public void testAddAccount() {
		Mockito.when(this.numGen.genNumber()).thenReturn(ACC_NUM);
		Mockito.when(this.prizeGen.genPrize(ACC_NUM)).thenReturn(PRIZE);

		assertEquals(this.RESPONSE_1, this.service.addAccount(new Account()));

		Mockito.verify(this.numGen, times(1)).genNumber();
		Mockito.verify(this.prizeGen, times(1)).genPrize(ACC_NUM);
	}

}
