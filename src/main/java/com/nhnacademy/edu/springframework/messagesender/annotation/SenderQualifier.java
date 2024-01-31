package com.nhnacademy.edu.springframework.messagesender.annotation;

import com.nhnacademy.edu.springframework.messagesender.Enum.Sender;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface SenderQualifier {
    Sender sender();
    boolean dummy();
}
