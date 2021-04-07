package com.standbyme.datasourcedynamic.config;

import com.standbyme.datasourcedynamic.config.annotation.TestAnno;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class SpringAopTest {


    @Around("@annotation(testAnno)")
    public Object around(ProceedingJoinPoint point, TestAnno testAnno) {

        System.out.println("执行环绕通知--前");

        Object proceed = null;
        try {
            Object[] args = point.getArgs();
            System.out.println((Integer) args[0]);
            args[0] = 808;
            proceed = point.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("直接环绕通知--后");

        return proceed;

    }

    /*@Before("@annotation(testAnno)")
    public Object before(ProceedingJoinPoint point, TestAnno testAnno) {
        System.out.println("执行前置通知");
        Object proceed = null;
        try {
            proceed = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }*/


}
