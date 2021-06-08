package com.human.security;

import com.human.users.MyUserDetailsService;
import com.human.users.User;
import com.human.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/auth")
public class SecurityController {

    @Autowired
    MyUserDetailsService myUserDetailsService;


    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) throws Exception{
       return myUserDetailsService.login(authRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<User> addNewUser (@RequestBody User user) throws Exception {
        try {
            myUserDetailsService.register(user);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return new ResponseEntity <User>(user, HttpStatus.CREATED);
    }

}
