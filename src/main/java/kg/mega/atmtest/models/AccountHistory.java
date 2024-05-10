package kg.mega.atmtest.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "account_histories")

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountHistory {

    @Id
            @GeneratedValue
    Long id;
    double amount;
    Date addDate;
    @ManyToOne
    @JoinColumn(name = "card_account_id")
    CardAccount cardAccount;

    

}
