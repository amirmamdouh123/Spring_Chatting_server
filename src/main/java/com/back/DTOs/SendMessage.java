package com.back.DTOs;

import com.back.Entities.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessage {

    User from;

    User to;

    String message;
}
