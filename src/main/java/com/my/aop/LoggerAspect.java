package com.my.aop;

import com.my.exception.BusinessException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description: java类作用描述
 * @Author: luqihua
 * @CreateDate: 2019/5/2$ 23:21$
 */

@Aspect
@Component
public class LoggerAspect {
    Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
    public static long startTime;
    public static long endTime;

    @Pointcut(value = "execution(* com.my.controller.*.*(..))")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        logger.info(joinPoint.getTarget() + joinPoint.getSignature().getName() + "--前置切面开始,参数为{"+Arrays.asList(joinPoint.getArgs())+"}");
        startTime = System.currentTimeMillis();
    }

    @After(value = "pointCut()")
    public void after() {
        logger.info("前置切面结束");
        endTime = System.currentTimeMillis() - startTime;
    }

    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void getAfterReturn(Object result) {
        logger.info("本次接口耗时={}ms", endTime);
        logger.info("afterReturning={}", result.toString());
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        throw new BusinessException("切面捕获异常{"+ joinPoint.getSignature().getName()+"}", exception.getMessage());
    }
}
