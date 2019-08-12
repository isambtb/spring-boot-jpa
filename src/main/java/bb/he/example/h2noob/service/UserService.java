package bb.he.example.h2noob.service;

import bb.he.example.h2noob.domain.User;
import bb.he.example.h2noob.repository.UserRepository;
import bb.he.example.h2noob.service.serviceexceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) throws UserException{
        final Optional<User> byUsernameOrEmail = userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail());
        if(byUsernameOrEmail.isPresent()){
            throw new IllegalArgumentException("username or Email is already in User!!");
        }
        return userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
