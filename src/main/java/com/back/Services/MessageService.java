package com.back.Services;

import com.back.Entities.Chating.Chat;
import com.back.Entities.Chating.ChatMember;
import com.back.Entities.Chating.Message;
import com.back.Repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageRepo messageRepo;

    public String insertMessage(Chat chat, ChatMember chatMember, String content){

        Message message = new Message(content);
        message.setChat(chat);
        message.setChatMember(chatMember);

        messageRepo.save(message);
        return "message is sent";
    }


}
