package com.example.demo.service;

import com.example.demo.model.BankOperationDto;
import org.springframework.stereotype.Service;

/**
 * Service to get from banks information regarding in and out transactions via user account
 */

@Service
public class BankIntegrationService {

    /**
     * @param operationDto customer's bank transaction data {@link BankOperationDto}
     */
    public void getBankOperationData(BankOperationDto operationDto){ //Not Finished
    }

    /**
     *
     * @param userAccountNumber user account in bank
     * @param userBankUin UIN of bank hosting user account
     * @return user account amount
     */
    public int getUserBalance(int userAccountNumber, int userBankUin){
        return 0;
    }

}
