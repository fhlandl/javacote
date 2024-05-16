package hello.javacote.aop;

import hello.javacote.annotation.TimeLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class TimeLogAspect {

    @Around("@annotation(timeLog)")
    public Object timeLog(ProceedingJoinPoint joinPoint, TimeLog timeLog) throws Throwable {

        long startTimeMs = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTimeMs = System.currentTimeMillis();
        long duration = endTimeMs - startTimeMs;

        log.info("duration: {} ms", duration);

        return result;
    }
}
