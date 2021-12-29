package com.example.be_webbanhang.controller;

import com.example.be_webbanhang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.be_webbanhang.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") int idUser) {
        userService.removeUser(idUser);
    }

    @PutMapping("/updateUser/{id}")
    public User updateAdmin(@RequestBody User user,
                             @PathVariable("id") int idUser) {
        return userService.updateUser(user, idUser);
    }

}
