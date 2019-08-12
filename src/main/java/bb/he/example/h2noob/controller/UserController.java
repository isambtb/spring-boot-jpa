package bb.he.example.h2noob.controller;

import bb.he.example.h2noob.domain.User;
import bb.he.example.h2noob.service.UserService;
import bb.he.example.h2noob.service.serviceexceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    @RequestMapping("/create-user")
    public User save(@RequestBody User user) throws UserException {
        return userService.save(user);
    }

    @PostMapping
    @RequestMapping("/getAll-users")
    public Iterable<User> getAllUsers() {
        return userService.findAll();
    }

}
