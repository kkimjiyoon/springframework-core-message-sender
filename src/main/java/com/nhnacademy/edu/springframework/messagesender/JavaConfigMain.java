package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.config.MainConfig;
import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigMain {
    public static void main(String[] args) {
        User user = new User("jiyoon@naver.com", "010-1234-5678");

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework.messagesender.config"); // 이 패키지 밑에 있는 @Configuration이 붙은 클래스를 찾음
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        MessageSendService service = context.getBean("messageSendService", MessageSendService.class);

        service.doSendMessage(user, "hello");
    }
}
