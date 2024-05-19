package com.example.demo.controller;

import com.example.demo.service.FinRulesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * FinRulesController implements some rules which help user to train good habits of funds handling
 */
@RequiredArgsConstructor
@Controller
@RequestMapping("/rules")
public class FinRulesController {

    private final FinRulesService finRulesService;

    /**
     * @param userId User Data Base identifier
     * @param amount amount of funds of supposed expense
     * @return True if user has enough funds to spend accordingly to limits, otherwise false
     */
    @PostMapping("/approve")
    public ResponseEntity<Boolean> requestApprovalOnExpense(long userId, int amount){
        return finRulesService.requestForExpenseApproval(userId, amount);}
}
