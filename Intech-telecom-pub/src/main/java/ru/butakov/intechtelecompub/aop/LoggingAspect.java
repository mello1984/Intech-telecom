package ru.butakov.intechtelecompub.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

@Aspect
@Component
public class LoggingAspect {

    @Around("ru.butakov.intechtelecompub.aop.Pointcuts.loggable()")
    public Object loggingAfter(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger log = getLogger(joinPoint.getTarget().getClass());

        log.info("Logging before: " + getLoggingString(joinPoint));
        Object o = joinPoint.proceed();
        log.info("Logging after: " + getLoggingString(joinPoint) + ", result=" + o.toString());
        return o;
    }

    private String getLoggingString(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));

        return String.format("method=%s, args=[%s]", method, args);
    }
}
