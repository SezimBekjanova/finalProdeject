package kg.megacom.finalprodeject.services;

import kg.megacom.finalprodeject.models.User;
import kg.megacom.finalprodeject.models.dto.UserDto;
import kg.megacom.finalprodeject.models.enums.StatusUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);

    User findById(Long id);

    User update(Long id, StatusUser status);

    UserDto addPhoto(User user, MultipartFile file);

    List<User> findAll();

    ResponseEntity info(Long id);
}
