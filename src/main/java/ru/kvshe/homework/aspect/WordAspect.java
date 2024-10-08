package ru.kvshe.homework.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j(topic = "log WordService")
public class WordAspect {
    @Pointcut("execution(* ru.kvshe.homework.service.WordService.*(..))")
    public void wordServicePointcut() {
    }

    @Before(value = "wordServicePointcut()")
    public void beforeWordService(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Method {} is started", methodName);
    }

    @AfterThrowing(value = "wordServicePointcut()", throwing = "ex")
    public void afterWordService(JoinPoint joinPoint, Exception ex) {
        log.info("Method {} throw exception {}",
                joinPoint.getSignature().getName(),
                ex.getClass().getName());
    }

    @Around(value = "wordServicePointcut()")
    public Object timerWordService(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;

        log.info("Method {} executed in {} ms",
                joinPoint.getSignature().getName(),
                duration);

        return result;
    }
}
