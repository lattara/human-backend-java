package com.human.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("User not found " + userName));
        return user.map(MyUserDetails::new).get();
    }

    public User register(User user) throws Exception {
        User newUser = new User();
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new Exception("Email is taken");
        }
        if(userRepository.findByUserName(user.getUserName()).isPresent()){
            throw new Exception("Username is taken");
        }
        else {
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
            newUser.setUserName(user.getUserName());
            newUser.setActive(user.isActive());
            newUser.setRoles(user.getRoles());
            newUser.setEmail(user.getEmail());
            newUser.setAddresses(null);
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            userRepository.save(newUser);
        }
        return newUser;
    }
}
