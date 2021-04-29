package com.example.demo.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping (path= "/users")

public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(path= "/all")
    public @ResponseBody Iterable <User> getAllUsers (){
        return userRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<User> getTopic(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PostMapping(path="/addNew")
    public User addNewUser (@RequestBody User user){ // wia @RequestBody we automatically get the user
        System.out.println(user);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        User userToDelete = userRepository.findById(id).get();
        userRepository.delete(userToDelete);
    }


}
