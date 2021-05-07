package com.human.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/users")

public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public @ResponseBody Iterable <User> getAllUsers (){
        return userService.getAll();
    }

    @RequestMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getById(id);

    }

    @PostMapping("/new")
    public User addNewUser (@RequestBody User user){
        return userService.save(user);
    }

    @PatchMapping("/{id}/update")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        return userService.update(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }



}
