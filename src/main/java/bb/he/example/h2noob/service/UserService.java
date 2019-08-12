package bb.he.example.h2noob.service;

import bb.he.example.h2noob.domain.User;
import bb.he.example.h2noob.repository.RoleRepository;
import bb.he.example.h2noob.repository.UserRepository;
import bb.he.example.h2noob.service.serviceexceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(User user) throws UserException{
        final Optional<User> byUsernameOrEmail = userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if(byUsernameOrEmail.isPresent()){
            throw new IllegalArgumentException("username or Email is already in User!!");
        }
        if(roleRepository.existsByUserRole(user.getRole().getUserRole())){
            LOGGER.info("## RoleExists");
            System.out.println(user.getRole().getUserRole());
            user.setRole(roleRepository.findByUserRole(user.getRole().getUserRole()));
        }
        return userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
