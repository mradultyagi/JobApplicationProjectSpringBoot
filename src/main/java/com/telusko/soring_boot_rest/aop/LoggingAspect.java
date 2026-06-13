package com.telusko.soring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.telusko.soring_boot_rest.service.JobService.*(..))")
    public void logMethodCall(){
        LOGGER.info("Before Method on service called");
    }
    @After("execution(* com.telusko.soring_boot_rest.service.JobService.getJob(..))")
    public void logMethodExecute(JoinPoint jp){
        LOGGER.info("Method executed " + jp.getSignature().getName());
    }
    @Around("execution(* com.telusko.soring_boot_rest.service.JobService.*(..))")
    public Object logMethodDuring(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("Around Method on service called");
        return joinPoint.proceed();
    }
}
