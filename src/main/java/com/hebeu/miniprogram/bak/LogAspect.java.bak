package com.hebeu.miniprogram.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect  {
    @Pointcut("execution(public * com.hebeu.miniprogram.controller..*.*(..))")
    public void webLog() {
    }

    @Around("webLog()")
    public Object around(ProceedingJoinPoint joinPoint)throws Throwable{
        Object proceed = joinPoint.proceed();
        log.info("METHOD : {} ; REQUEST：{} ; RESPONSE : {}",
                joinPoint.getSignature().toShortString(),
                joinPoint.getArgs(),
                proceed);
        return proceed;
    }
}
