package com.back.Services;

import com.back.Entities.Chating.Chat;
import com.back.Entities.Chating.ChatMember;
import com.back.Entities.Chating.Message;
import com.back.Entities.User;
import com.back.Repos.ChatRepo;
import com.back.Repos.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    ChatRepo chatRepo;

    @Autowired
    MessageService messageService;

    @Autowired
    ChatMemberService chatMemberService;

@Transactional
    public void addNewMessage(User from, User to , String content){ //individual

        //find the Chat between both users

        List<ChatMember> chatMembersFrom= from.getChatMembers();
        List<ChatMember>  chatMembersTo = to.getChatMembers();
        List<ChatMember> chatMemberResult= new ArrayList<>();

    System.out.println("user from : "+ from);
    System.out.println("chatMembers from : "+ from.getChatMembers());
    System.out.println("user to : "+ to);
    System.out.println("chatMembers to : "+ to.getChatMembers());
        if(chatMembersFrom.isEmpty() || chatMembersTo.isEmpty()){

        }else {

            chatMemberResult = chatMembersTo.stream().flatMap((chatMember1 ->   //from { chatMem1 ,chatMem2 }
                    chatMembersFrom
                            .stream()
                            .filter((chatMember2 -> chatMember2.getChat().getId().equals(chatMember1.getChat().getId())))
            )).toList();

            System.out.println(chatMemberResult);
        }

        ChatMember chatMember;
        Chat chat;

        //if not found create new ChatMembers and Chat
        if(chatMemberResult.isEmpty()){

            chat = this.createNewChat();

            chatMember = chatMemberService.createChatMember(from,chat);
            chatMemberService.createChatMember(to,chat);

        }else {
            chatMember = chatMemberResult.get(0);
            chat = chatMember.getChat();
        }

        messageService.insertMessage(chat , chatMember ,content);
    }

//    public void addNewMessage(User from,Chat to){  //group
//
//    }

    public Chat createNewChat() {  //group
        Chat chat = new Chat();
        chat.setChatMembers(new ArrayList<>());
        chat.setMessages(new ArrayList<>());
        return chatRepo.save(chat);
    }

    public List<Chat> getAllChats() {
    return chatRepo.findAll();
    }

//    public List<Chat> getChatBetweenUsers(Long id1, Long id2) {
//
//    }


//    public Chat CheckChatPersistence(User from, User to) {
//
//        Chat QueriedChat = null;
//        for (ChatMember chatMember : from.getChatMembers()) {
//
//            Chat chat = chatMember.getChat();
//
//            if (chat.getChatMembers().size() != 2) {
//                continue;
//            }
//
//            for (ChatMember member2 : chat.getChatMembers()) {
//                if (member2.getUser().getId().equals(to.getId())) {
//                    QueriedChat = chat;
//                    break;
//                }
//            }
//        }
//
//        if(QueriedChat==null){
//            QueriedChat= new Chat();
//        }
//        return QueriedChat;
//    }
}
