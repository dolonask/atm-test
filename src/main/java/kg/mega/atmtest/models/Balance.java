package kg.mega.atmtest.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "balances")

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Balance {

    @Id
            @GeneratedValue
    Long id;

    double balance;
    double blockedBalance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBlockedBalance() {
        return blockedBalance;
    }

    public void setBlockedBalance(double blockedBalance) {
        this.blockedBalance = blockedBalance;
    }
}
