package com.nhnacademy.edu.springframework.messagesender.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class ExecutionLogger {
    @Around("execution(* com.nhnacademy.edu.springframework.messagesender.sender.MessageSender.sendMessage(..))")
    public Object printExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch("ExecutionTime");
        stopWatch.start();
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }
}
