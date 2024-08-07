package com.back;

import com.back.Entities.Chating.Chat;
import com.back.Entities.Chating.IChat;
import com.back.proxy.ChatInvocationHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Proxy;

@SpringBootApplication
public class BackApplication {

	public static void main(String[] args) {

		ChatInvocationHandler c =new ChatInvocationHandler(new Chat());

		IChat iChat = (IChat) Proxy.newProxyInstance(IChat.class.getClassLoader() , new Class[]{IChat.class} , c);

		iChat.StringMessage("aa");
//		SpringApplication.run(BackApplication.class, args);
	}

}
