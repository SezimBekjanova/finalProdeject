package kg.megacom.finalprodeject.services;

import kg.megacom.finalprodeject.models.User;
import kg.megacom.finalprodeject.models.dto.UserDto;

import java.util.Optional;

public interface UserService {
    User save(UserDto userDto);
    Optional<User> findById(Long id);
    void update(Long id, String nameUser, String number, String email );
}
