package com.example.eshop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Collection;

@Component
@Aspect
@Slf4j
public class LoggableAspect {

    @Pointcut("@annotation(Loggable)")
    public void executeLogging() {}

//    @Before("executeLogging()")
    @AfterReturning(value = "executeLogging()", returning = "returnValue")
    public void logMethodCall(JoinPoint joinPoint, Object returnValue) {
        StringBuilder messageBuilder = new StringBuilder(joinPoint.getSourceLocation().getWithinType().getSimpleName());
        messageBuilder.append(".");
        messageBuilder.append(joinPoint.getSignature().getName());
        messageBuilder.append("(");
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (i > 0) {
                    messageBuilder.append(", ");
                }
                messageBuilder.append(args[i]);
            }
        }
        messageBuilder.append(") -> ");

        if(returnValue instanceof Collection) {
            messageBuilder.append(((Collection<?>) returnValue).size()).append(" instance(s)");
        } else {
            messageBuilder.append(returnValue.toString());
        }
        log.debug(messageBuilder.toString());
    }

//    @Around("executeLogging()")
//    public void aroundMethodCall(JoinPoint joinPoint) {
//        log.info("around call " + joinPoint.getSignature().getName());
//    }
}
