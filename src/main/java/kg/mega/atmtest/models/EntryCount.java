package kg.mega.atmtest.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "entries_count")

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EntryCount {

    @Id
            @GeneratedValue
    Long id;

    int triesCount;
    int maxCount;

    @OneToOne
    CardAccount cardAccount;
    

}
