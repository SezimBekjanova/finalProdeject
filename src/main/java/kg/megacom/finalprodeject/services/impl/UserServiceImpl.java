package kg.megacom.finalprodeject.services.impl;

import kg.megacom.finalprodeject.mappers.UserMapper;
import kg.megacom.finalprodeject.models.User;
import kg.megacom.finalprodeject.models.dto.UserDto;
import kg.megacom.finalprodeject.repo.UserRepo;
import kg.megacom.finalprodeject.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
        this.userMapper = UserMapper.INSTANCE;
    }

    @Override
    public User save(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userRepo.save(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = userRepo.findById(id);
        return user;
    }

    @Override
    public void update(Long id, String nameUser, String number, String email ) {
        userRepo.update(id,nameUser,number,email);
    }

}
