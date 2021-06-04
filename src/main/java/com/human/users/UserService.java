package com.human.users;
import com.human.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Iterable<User> getAll(){
        return userRepository.findAll();
    }

    public User save(User user) {
        // TODO implement if user with email exists

        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setActive(user.isActive());
        newUser.setAddresses(user.getAddresses());
        newUser.setEmail(user.getEmail());
        newUser.setRoles(user.getRoles());
        newUser.setUserName(user.getUserName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(User user, Long id) { user.setId(id); return userRepository.save(user);  }

}

