package kg.megacom.finalprodeject.services;

import kg.megacom.finalprodeject.models.User;
import kg.megacom.finalprodeject.models.dto.UserDto;
import kg.megacom.finalprodeject.models.enums.StatusUser;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto save(UserDto userDto);
    Optional<User> findById(Long id);
    User update(Long id, StatusUser status);

    UserDto addPhoto(User user, MultipartFile file);

    List<User> findAll();
}
