package com.statistics.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.statistics.common.APIErrors;
import com.statistics.exception.RequestValidationException;
import com.statistics.model.Transaction;
import com.statistics.service.TransactionService;

/**
 * Controller for Incoming Transactions.
 *
 * @author shivamoberoi
 */
@RestController
@RequestMapping("/transactions")
public class TransactionController {

	public static final int TIME_LIMIT = 60;

	@Autowired
	private TransactionService transactionService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> addTransaction(@RequestBody Transaction transaction) {
		Optional<Long> optionalTime = Optional.ofNullable(transaction.getTimestamp());
		if (!optionalTime.isPresent()){
			throw new RequestValidationException(APIErrors.VALIDATION_MISSING_TIMESTAMP);
		}
		else if ((System.currentTimeMillis() - transaction.getTimestamp()) / 1000 > TIME_LIMIT) {
			// if transaction did not happened within the last minute
			return new ResponseEntity<>(NO_CONTENT);
		} else {
			transactionService.addTransaction(transaction);
			return new ResponseEntity<>(CREATED);
		}

	}
}
