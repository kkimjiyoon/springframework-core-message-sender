package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.annotation.SMS;
import com.nhnacademy.edu.springframework.messagesender.Enum.Sender;
import com.nhnacademy.edu.springframework.messagesender.annotation.SenderQualifier;
import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class MessageSendService {
//    private final MessageSender messageSender; // MessageSendService 는 messageSender에 의존

    private String phoneNumber;

    private MessageSender messageSender; // messageSender에 의존하고 있음

    public MessageSendService() { // 기본 생성자
        System.out.println("-----------constructor injection method-------------");
    }

//    @Autowired
    public MessageSendService(@Qualifier("smsMessageSender") MessageSender messageSender, @Value("${phoneNumber}") String phoneNumber) {
        System.out.println("-----------constructor injection method-------------");
        this.messageSender = messageSender;
        this.phoneNumber = phoneNumber;
    }

    public MessageSendService(@SenderQualifier(sender = Sender.EMAIL, dummy = false) MessageSender messageSender) { // 적절한 구현체를 주입
        System.out.println("-----------constructor injection method-------------");
        this.messageSender = messageSender;
    }

    public void setSmsMessageSender(MessageSender messageSender) {
        System.out.println("setMessageSender invoked");
        this.messageSender = messageSender;
    }


    public void doSendMessage(User user, String message) {
        user.setPhoneNumber(phoneNumber);
        messageSender.sendMessage(user, message);
    }

}
