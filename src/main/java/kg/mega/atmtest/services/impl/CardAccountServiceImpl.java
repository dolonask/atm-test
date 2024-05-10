package kg.mega.atmtest.services.impl;

import jakarta.transaction.Transactional;
import kg.mega.atmtest.exceptions.NoAccountFound;
import kg.mega.atmtest.exceptions.NotEnoughMoney;
import kg.mega.atmtest.models.Balance;
import kg.mega.atmtest.models.CardAccount;
import kg.mega.atmtest.models.dto.AccountNumberAmountDto;
import kg.mega.atmtest.models.dto.BalanceDto;
import kg.mega.atmtest.repositories.CardAccountRepo;
import kg.mega.atmtest.services.BalanceService;
import kg.mega.atmtest.services.CardAccountService;
import org.springframework.stereotype.Service;

@Service
public class CardAccountServiceImpl implements CardAccountService {

    private final CardAccountRepo accountRepo;
    private final BalanceService balanceService;

    public CardAccountServiceImpl(CardAccountRepo accountRepo, BalanceService balanceService) {
        this.accountRepo = accountRepo;
        this.balanceService = balanceService;
    }

    @Override
    public CardAccount findByAccountNumber(String accountNumber) {
        CardAccount cardAccount = accountRepo.findByAccountNumber(accountNumber);
        if (cardAccount == null)
            throw new NoAccountFound(accountNumber);

        return cardAccount;
    }

    @Transactional
    @Override
    public BalanceDto checkAndBlockBalance(AccountNumberAmountDto accountNumberAmountDto) {

        CardAccount cardAccount = findByAccountNumber(accountNumberAmountDto.accountNumber());

        if (cardAccount.getBalance().getBalance() < accountNumberAmountDto.amount())
            throw new NotEnoughMoney();

        Balance balance = cardAccount.getBalance();
        balance.setBalance(balance.getBalance() - accountNumberAmountDto.amount());
        balance.setBlockedBalance(balance.getBlockedBalance() + accountNumberAmountDto.amount());
        balanceService.saveBalance(balance);

        return new BalanceDto(balance.getBalance(), balance.getBlockedBalance());
    }
}
