package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.sender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class   XmlMain {
    public static void main(String[] args) {

        User user = new User("jiyoon@naver.com", "010-1234-5678");

        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) { // new 할 때 ApplicationContext 내에 객체가 싱글톤으로(한 개) 만들어짐, 이 라인이 끝나면 생성 됨.
            MessageSender emailMessageSender = context.getBean("emailMessageSender", MessageSender.class);
            MessageSender smsMessageSender = context.getBean("smsMessageSender", MessageSender.class);

            MessageSendService messageSendService = new MessageSendService(emailMessageSender);
//            MessageSendService messageSendService = new MessageSendService(smsMessageSender);
            messageSendService.doSendMessage(user, "hello");
        }
    }

}
// prototype 으로 scope을 설정해주면 context 내에서 주입을 할 때 *getBean 할 때 마다 객체가 만들어짐, 매번 생성

// prototype으로 설정하면 위에서 생성된 객체를 가져다 씀, 새로 생성 X