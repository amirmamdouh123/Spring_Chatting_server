package com.back.Controllers;

import com.back.DTOs.SendMessage;
import com.back.Entities.Chating.Chat;
import com.back.Entities.User;
import com.back.Services.ChatService;
import com.back.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("chat")
public class ChatController {

    @Autowired
    ChatService chatService;

    @Autowired
    UserService userService;

    @PostMapping()
    public String sendMessage(@RequestBody SendMessage sendMessage) throws UserPrincipalNotFoundException {

//        System.out.println(sendMessage.getFrom());
//        System.out.println("------------");
//        System.out.println(sendMessage.getFrom());
//
        User from = userService.getUserById(sendMessage.getFrom().getId());
        User to = userService.getUserById(sendMessage.getTo().getId());
//        System.out.println(from);
//        System.out.println("------------");
//        System.out.println(to);

        String content = sendMessage.getMessage();
        chatService.addNewMessage(from, to, content);
        return "Message is sent";
    }

    @GetMapping("all")
    public List<Chat> getAllChats() {
        return chatService.getAllChats();
    }

//    @PostMapping("{id1}/{id2}")
//    public List<Chat> getChat(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2) {
//        return chatService.getChatBetweenUsers(id1,id2);
//    }
}
