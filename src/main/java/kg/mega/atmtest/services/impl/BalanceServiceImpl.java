package kg.mega.atmtest.services.impl;

import kg.mega.atmtest.models.Balance;
import kg.mega.atmtest.repositories.BalanceRepo;
import kg.mega.atmtest.services.BalanceService;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepo balanceRepo;

    public BalanceServiceImpl(BalanceRepo balanceRepo) {
        this.balanceRepo = balanceRepo;
    }

    @Override
    public void saveBalance(Balance balance) {
        balanceRepo.save(balance);
    }
}
