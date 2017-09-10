package com.statistics;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.statistics.exception.RequestValidationException;
import com.statistics.model.Transaction;
import com.statistics.service.StatisticsServiceImpl;
import com.statistics.service.TransactionService;
import com.statistics.service.TransactionServiceImpl;

/**
 * @author shivamoberoi
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTests {

	@Autowired
	private TransactionService transactionService;

	@Mock
	private StatisticsServiceImpl statisticsServiceMock;

	@InjectMocks
	private TransactionServiceImpl transactionServiceMock;

	@Test(expected = RequestValidationException.class)
	public void whenEmptyRequestBody_exceptionThrown() {
		transactionService.addTransaction(null);
	}

	@Test(expected = RequestValidationException.class)
	public void whenMissingAmountField_exceptionThrown() {
		transactionService.addTransaction(new Transaction(null, System.currentTimeMillis()));
	}

	@Test
	public void whenValidTransaction_flowSucceeds() {
		doNothing().when(statisticsServiceMock).computeStatistics(any(Transaction.class));
		transactionServiceMock.addTransaction(new Transaction(12.5, System.currentTimeMillis()));
		verify(statisticsServiceMock, times(1)).computeStatistics(any(Transaction.class));
	}
}
