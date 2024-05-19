package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FinRulesService {
    /**
     * @param userId User Data Base identifier
     * @param amount amount of funds of supposed expense
     * @return True if user has enough funds to spend accordingly to limits, otherwise false
     */
    public ResponseEntity<Boolean> requestForExpenseApproval(long userId, int amount) {
        return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_IMPLEMENTED);
    }
}
