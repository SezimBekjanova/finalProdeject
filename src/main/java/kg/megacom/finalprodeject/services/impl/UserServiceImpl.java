package kg.megacom.finalprodeject.services.impl;

import kg.megacom.finalprodeject.mappers.UserMapper;
import kg.megacom.finalprodeject.microservice.FileServiceFeign;
import kg.megacom.finalprodeject.microservice.json.Response;
import kg.megacom.finalprodeject.models.User;
import kg.megacom.finalprodeject.models.dto.UserDto;
import kg.megacom.finalprodeject.models.enums.StatusUser;
import kg.megacom.finalprodeject.repo.UserRepo;
import kg.megacom.finalprodeject.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final FileServiceFeign fileServiceFeign;

    public UserServiceImpl(UserRepo userRepo, FileServiceFeign fileServiceFeign) {
        this.userRepo = userRepo;
        this.fileServiceFeign = fileServiceFeign;
        this.userMapper = UserMapper.INSTANCE;
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userRepo.save(user);
        UserDto userDto1 = new UserDto();
        userDto1.setId(user.getId());
        return userDto1;
        // регистрация без статуса
    }



    @Override
    public User findById(Long id) {

        //if(Objects.isNull(user)){
        //    throw new RuntimeException("Пользователь с таким кодом не существует!");
        //}
        //return user;
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("Такого пользователя нет"));

    }
   @Override
   public User update(Long id,StatusUser status) {
        User user = userRepo.findById(id).orElseThrow();
        user.setDate(new Date());
        user.setStatus(status);
       userRepo.save(user);
       return user;
       // добаволение/изменение статуса
   }

    @Override
    public UserDto addPhoto(User user, MultipartFile file) {
        Response response = fileServiceFeign.upload(file);
        user.setPhoto(response.getDownloadUri());
        userRepo.save(user);
        UserDto userDto = userMapper.toDto(user);
        return userDto;
        // добавление фото без статуса
    }

    @Override
    public List<User> findAll() {
        List<User> userList = userRepo.findAll();
        return userList;
    }

    @Override
    public ResponseEntity info(Long id) {
        try {
            Optional<User> user = userRepo.findById(id);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            return ResponseEntity.ok("Такой пользователь не найден!");
        }
    }
}
