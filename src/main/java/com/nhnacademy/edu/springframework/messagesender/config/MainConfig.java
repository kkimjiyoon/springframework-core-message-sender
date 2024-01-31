package com.nhnacademy.edu.springframework.messagesender.config;

import com.nhnacademy.edu.springframework.messagesender.sender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.sender.SmsMessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.messagesender"}) // 하위에 있는 모든 클래스를 뒤짐 -> @componert, @repository 등등이 붙은 클래스들을 로딩 함, 안 붙어있으면 spring bean으로 등록이 안되어있는 것들임.
@PropertySource("classpath:sender.properties")
public class MainConfig {

    private final MessageSender smsMessageSender;
//    private final MessageSender emailMessageSender;
    private final String phoneNumber;

//    public MainConfig(MessageSender smsMessageSender, MessageSender emailMessageSender,@Value("${phoneNumber}") String phoneNumber) {
//        this.smsMessageSender = smsMessageSender;
//        this.emailMessageSender = emailMessageSender;
//        this.phoneNumber = phoneNumber;
//    }

    public MainConfig(@Qualifier("smsMessageSender") MessageSender smsMessageSender ,@Value("${phoneNumber}") String phoneNumber) {
        this.smsMessageSender = smsMessageSender;
        this.phoneNumber = phoneNumber;
    }

    @Bean
    public MessageSendService messageSendService() { // 요 객체가 모여서 spring bean이 됨.
        return new MessageSendService(smsMessageSender, phoneNumber);
    }
}
