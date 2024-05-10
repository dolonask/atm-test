package kg.mega.atmtest.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "clients")

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String name;


}
