package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.sender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeMain {
    public static void main(String[] args) {
        User user = new User("jiyoon@naver.com", "010-1234-5678");

        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
//            System.out.println("---------");
//            new MessageSendService(context.getBean("smsMessageSender" , MessageSender.class)).doSendMessage(user, "hello");
//
//            System.out.println("---------");
//            new MessageSendService(context.getBean("smsMessageSender" , MessageSender.class)).doSendMessage(user, "hello");

            System.out.println("---------");
            new MessageSendService(context.getBean("emailMessageSender" , MessageSender.class)).doSendMessage(user, "hello");

            System.out.println("---------");
            new MessageSendService(context.getBean("emailMessageSender" , MessageSender.class)).doSendMessage(user, "hello");

            System.out.println("---------");

//            MessageSender a1 = context.getBean("emailMessageSender", MessageSender.class);
//            MessageSender a2 = context.getBean("emailMessageSender", MessageSender.class);
//            MessageSender a3 = context.getBean("smsMessageSender", MessageSender.class);
//            MessageSender a4 = context.getBean("smsMessageSender", MessageSender.class);

//            System.out.println(a1.equals(a2));
//            System.out.println(a3.equals(a4));
//
//            System.out.println(a1.hashCode());
//            System.out.println(a2.hashCode());
        }
    }
}
