package com.nhnacademy.edu.springframework.messagesender.sender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.springframework.stereotype.Component;


@Component
public class SmsMessageSender implements MessageSender {

    public SmsMessageSender() {
        System.out.println("smsMessageSender initiated!!");
    }

    public void init() {
        System.out.println("smsMessageSender init called!");
    }

    @Override
    public void sendMessage(User user, String message) {
        System.out.println("SMS Message Sent to " + user.getPhoneNumber() + " : " + message);
    }
}
