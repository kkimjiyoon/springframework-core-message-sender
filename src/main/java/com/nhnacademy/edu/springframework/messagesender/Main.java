package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.sender.EmailMessageSender;
import com.nhnacademy.edu.springframework.messagesender.sender.SmsMessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;

public class Main {
    public static void main(String[] args) {
        User user = new User("jiyoon@naver.com", "010-1234-5678");
        new MessageSendService(new SmsMessageSender()).doSendMessage(user, "hello");
        new MessageSendService(new EmailMessageSender()).doSendMessage(user, "hello");

    }
}
