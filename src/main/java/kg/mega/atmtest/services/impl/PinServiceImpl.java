package kg.mega.atmtest.services.impl;

import kg.mega.atmtest.exceptions.ClientNotActive;
import kg.mega.atmtest.exceptions.IncorrectPin;
import kg.mega.atmtest.models.CardAccount;
import kg.mega.atmtest.models.dto.AccountPinDto;
import kg.mega.atmtest.models.dto.BalanceAndStatusDto;
import kg.mega.atmtest.services.CardAccountService;
import kg.mega.atmtest.services.PinService;
import org.springframework.stereotype.Service;

@Service
public class PinServiceImpl implements PinService {

    private final CardAccountService cardAccountService;

    public PinServiceImpl(CardAccountService cardAccountService) {
        this.cardAccountService = cardAccountService;
    }

    @Override
    public BalanceAndStatusDto checkPin(AccountPinDto accountPinDto) {

        CardAccount cardAccount = cardAccountService.findByAccountNumber(accountPinDto.accountNumber());

        if (!cardAccount.isActive())
            throw new ClientNotActive();

        if (cardAccount.getPin() != accountPinDto.pin())
            throw new IncorrectPin();


        BalanceAndStatusDto balanceAndStatusDto = new BalanceAndStatusDto(cardAccount.getBalance().getBalance(), cardAccount.isActive());
        return balanceAndStatusDto;
    }
}
