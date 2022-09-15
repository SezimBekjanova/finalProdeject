package kg.megacom.finalprodeject.models;

import kg.megacom.finalprodeject.models.enums.StatusUser;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userName;
    String email;
    String number;
    String photo;
    @Enumerated(value = EnumType.STRING)
    private StatusUser status;
    Date date;
}
