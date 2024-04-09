package com.example.api_takesample.Controller;

import com.example.api_takesample.Model.User;
import com.example.api_takesample.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getUser();
    }

    @PostMapping
    public void registeruser(@RequestBody User user) {
        userService.addNewUser();
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phoneNumber
    ){
        userService.updateUser(userId, name, address, email, phoneNumber);
    }
}
