package com.back.Services;

import com.back.Entities.Chating.Chat;
import com.back.Entities.Chating.ChatMember;
import com.back.Entities.User;
import com.back.Repos.ChatMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatMemberService {

    @Autowired
    private ChatMemberRepo chatMemberRepo;



    public ChatMember createChatMember(User user, Chat chat){
        ChatMember chatMember= new ChatMember(user,chat);

        return chatMemberRepo.save(chatMember);
    }


}
