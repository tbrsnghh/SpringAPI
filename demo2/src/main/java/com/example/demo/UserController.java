package com.example.demo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public User user1() {
        User user = new User("Nguyen Hoang Ha", 23, 8.5F);
        return user;
    }
}
