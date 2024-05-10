package kg.mega.atmtest.services;

import kg.mega.atmtest.models.CardAccount;
import kg.mega.atmtest.models.dto.AccountNumberAmountDto;
import kg.mega.atmtest.models.dto.BalanceDto;

public interface CardAccountService {

    CardAccount findByAccountNumber(String accountNumber);

    BalanceDto checkAndBlockBalance(AccountNumberAmountDto accountNumberAmountDto);



}
