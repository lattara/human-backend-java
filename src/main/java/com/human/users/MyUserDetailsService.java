package com.human.users;

import com.human.security.AuthRequest;
import com.human.security.AuthResponse;
import com.human.security.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtConfig jwtConfig;


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

    public ResponseEntity<AuthResponse> login (AuthRequest authRequest) throws Exception {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtConfig.generateToken(userDetails);
            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
            } catch (BadCredentialsException ex){
                throw new  Exception("Credentials not correct");
            }
        return ResponseEntity.ok(new AuthResponse(jwt));
    }

}
