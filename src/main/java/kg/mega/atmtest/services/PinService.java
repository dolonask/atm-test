package kg.mega.atmtest.services;

import kg.mega.atmtest.models.dto.AccountPinDto;
import kg.mega.atmtest.models.dto.BalanceAndStatusDto;

public interface PinService {
    BalanceAndStatusDto checkPin(AccountPinDto accountPinDto);
}
