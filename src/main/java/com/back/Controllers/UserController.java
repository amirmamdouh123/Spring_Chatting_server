package com.back.Controllers;


import com.back.DTOs.SendMessage;
import com.back.Entities.User;
import com.back.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("all")
    public List<User> getAllUsers(){
       return userService.getAllUsers();
    }

    @GetMapping("chats")
    public List<User> getAllChats(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User insertUser(@RequestBody User i){
        return userService.insertUser(i);
    }


}
