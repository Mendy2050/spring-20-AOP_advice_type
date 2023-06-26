package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Mendy
 * @create 2023-06-25 16:06
 */
@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(void com.itheima.dao.BookDao.update())")
    private void pt(){}

    @Pointcut("execution(int com.itheima.dao.BookDao.select())")
    private void pt2(){}

//    @Before("pt()")
    public void before() {
        System.out.println("before advice ...");
    }


    @After("pt2()")
    public void after() {
        System.out.println("after advice ...");
    }


//    @Around("pt()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before advice ...");

        //represent the call for the original operation
        pjp.proceed();

        System.out.println("around after advice ...");
    }


//    @Around("pt2()")
    public Object aroundSelect(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before advice ...");

        //represent the call for the original operation
        Integer ret = (Integer) pjp.proceed();
        System.out.println(ret);

        System.out.println("around after advice ...");

        return ret + 566;
    }


//@AfterReturning("pt2()")
    public void afterReturning() {
        System.out.println("afterReturning advice ...");
    }



    public void afterThrowing() {
        System.out.println("afterThrowing advice ...");
    }
}

