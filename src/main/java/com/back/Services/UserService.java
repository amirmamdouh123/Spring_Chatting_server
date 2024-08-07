package com.back.Services;

import com.back.DTOs.SendMessage;
import com.back.Entities.Chating.Chat;
import com.back.Entities.Chating.Message;
import com.back.Entities.User;
import com.back.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

//    public List<Chat> getAllChats(){
//        return userRepo.findByChatList();
//    }

    public User insertUser(User i){
        i.setChatMembers(new ArrayList<>());
        return userRepo.save(i);
    }

    public User getUserById(Long id) throws UserPrincipalNotFoundException {
        return userRepo.findById(id).orElseThrow( ()-> new UserPrincipalNotFoundException("User with id:"+ id +"is not found"));
    }



//    public String sendMessage(SendMessage message){
//        User from = message.getFrom();
//        User to = message.getTo();
//        Message messageObj = new Message(message.getMessage());
//
//        userRepo.findByChatList();
//        return "Message is sent Successfully";
//    }


}





