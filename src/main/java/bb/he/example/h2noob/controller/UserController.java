package bb.he.example.h2noob.controller;

import bb.he.example.h2noob.domain.User;
import bb.he.example.h2noob.service.UserService;
import bb.he.example.h2noob.service.serviceexceptions.UserException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper mapper;

    @PostMapping
    @RequestMapping("/create-user")
    public User save(@RequestBody User user) throws UserException {
        try {
            LOGGER.info("RequestBod:=>");
            System.out.println(mapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return userService.save(user);
    }

    @PostMapping
    @RequestMapping("/getAll-users")
    public Iterable<User> getAllUsers() {
        return userService.findAll();
    }

}
