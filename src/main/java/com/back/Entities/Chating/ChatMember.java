package com.back.Entities.Chating;


import com.back.Entities.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="chat_members")
@Setter
@Getter
@NoArgsConstructor
public class ChatMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "userid",referencedColumnName = "id" )
    @JsonIgnore
    User user;

    @ManyToOne
    @JoinColumn(name = "chat_id",referencedColumnName = "id" )
    @JsonIgnore
    Chat chat;

    public ChatMember(User user, Chat chat) {
        this.user = user;
        this.chat = chat;
    }

    @Override
    public String toString() {
        return "ChatMember{" +
                "id=" + id +
                ", user=" + user +
                ", chat=" + chat +
                '}';
    }
}
