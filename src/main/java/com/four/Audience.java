package com.four;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by 陈祥 on 2016/8/22.
 */
@Aspect
public class Audience {

    @Pointcut("execution(* com.four.Performance.perform(..))")
    public void performance(){}

    /*@Before("performance()")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats(){
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause(){
        System.out.println("CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }*/

    /**环绕通知**/
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp){
        try{
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            jp.proceed();
            jp.proceed();
            System.out.println("CLAP CLAP CLAP");
//            throw new RuntimeException("FUCK U");
        }catch (Throwable e){
            System.out.println("Demanding a refund");
        }
    }
}
