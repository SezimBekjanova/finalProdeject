package kg.megacom.finalprodeject.Controllers;

import kg.megacom.finalprodeject.models.User;
import kg.megacom.finalprodeject.models.dto.UserDto;
import kg.megacom.finalprodeject.models.enums.StatusUser;
import kg.megacom.finalprodeject.services.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @PostMapping("/save/photo")
    private User addPhoto(@RequestParam Long id, @RequestPart MultipartFile file){
        User user = userService.findById(id).orElseThrow();
        return userService.sddUser(user , file);
    }
    @GetMapping("/info")
    public Optional<User> getInfo(@RequestParam Long id){
        return userService.findById(id);
    }

    @PutMapping("/update")
    public User update(@RequestParam Long id, @RequestParam StatusUser status){
        return userService.update(id, status);
    }
}
