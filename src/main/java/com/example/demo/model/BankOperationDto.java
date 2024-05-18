package com.example.demo.model;

import lombok.Data;

import java.time.ZonedDateTime;

/**
 * DTO for bank operation of receiving or sending funds
 */
@Data
public class BankOperationDto {
    /**
     * moment of completion of operation
     */
    private ZonedDateTime zonedDateTime;

    /**
     * Category of operation
     */
    private BankOperationCategory operationCategory;

    /**
     * UIN applied to bank
     */
    private int bankUin;

    /**
     * User bank account number
     */
    private int customerBankAccount;

    /**
     * Counterparty bank UIN
     */
    private int counterPartyBankUin;

    /**
     * Counterparty account number
     */
    private int counterPartyBankAccount;

    /**
     * amount of funds
     */
    private long amount;

    /**
     * Details of operation
     */
    private String note;
}
