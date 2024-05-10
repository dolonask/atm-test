package kg.mega.atmtest.repositories;

import kg.mega.atmtest.models.CardAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardAccountRepo extends JpaRepository<CardAccount, Long> {

    CardAccount findByAccountNumber(String accountNumber);

}
