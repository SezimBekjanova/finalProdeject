package kg.megacom.finalprodeject.Controllers;

import kg.megacom.finalprodeject.models.User;
import kg.megacom.finalprodeject.models.dto.ServerStatistics;
import kg.megacom.finalprodeject.models.dto.UserDto;
import kg.megacom.finalprodeject.models.enums.StatusUser;
import kg.megacom.finalprodeject.services.ServiceStatisticsService;
import kg.megacom.finalprodeject.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ServiceStatisticsService serviceStatisticsService;

    public UserController(UserService userService, ServiceStatisticsService serviceStatisticsService) {
        this.userService = userService;
        this.serviceStatisticsService = serviceStatisticsService;
    }

    @PostMapping("/save")
    public UserDto save(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }
    @PostMapping("/save/photo")
    private UserDto addPhoto(@RequestParam Long id, @RequestPart MultipartFile file){
        User user = userService.findById(id);
        return userService.addPhoto(user , file);
    }

    @GetMapping("/info")
    public User getInfo(@RequestParam Long id){
        return userService.findById(id);
    }

    @GetMapping("/info/v2")
    public ResponseEntity findById(@RequestParam Long id){
        return userService.info(id);
    }

    @PutMapping("/update")
    public User update(@RequestParam Long id, @RequestParam StatusUser status){
        return userService.update(id, status);
    }

    @GetMapping("/serverStatistics")
    public List<ServerStatistics> serverStatistics(@RequestParam(required = false) StatusUser statusUser, @RequestParam(required = false)Date date){
        return serviceStatisticsService.serverStatistics(statusUser,date);}
}