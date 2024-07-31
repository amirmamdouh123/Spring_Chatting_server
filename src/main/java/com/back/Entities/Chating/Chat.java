package com.back.Entities.Chating;

import com.back.Entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "chats")
@Setter
@Getter
@NoArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @OneToMany(mappedBy = "chat")
    List<ChatMember> chatMembers;


    @OneToMany(mappedBy = "chat")
    List<Message> messages;


    public void addMessage(Message message){
        messages.add(message);
    }



}
