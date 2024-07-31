package com.back.Entities.Chating;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "messages")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String message;

    Date date=new Date();

    @ManyToOne
    @JoinColumn(name = "chat_id" , referencedColumnName = "id")
    @JsonIgnore
    Chat chat;

    @ManyToOne   //will cause error , cause referencedColumn has no property called user_id
    @JoinColumn(name = "userid" , referencedColumnName = "userid")
    ChatMember chatMember;




    public Message(String message) {
        this.message = message;
    }
}
