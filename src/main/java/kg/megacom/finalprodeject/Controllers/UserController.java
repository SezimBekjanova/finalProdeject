package kg.megacom.finalprodeject.Controllers;

import kg.megacom.finalprodeject.models.User;
import kg.megacom.finalprodeject.models.dto.UserDto;
import kg.megacom.finalprodeject.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public User save(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    @GetMapping("/info")
    public Optional<User> getInfo(@RequestParam Long id){
        return userService.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestParam Long id,@RequestParam  String nameUser,@RequestParam  String number,@RequestParam  String email ){
        userService.update(id, nameUser, number, email);
    }
}
