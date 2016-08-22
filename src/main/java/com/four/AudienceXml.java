package com.four;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by 陈祥 on 2016/8/22.
 * 无注解的Audience，Xml中声明通知
 */
@Aspect
public class AudienceXml {


    public void silenceCellPhones(){
        System.out.println("Silencing cell phones");
    }

    public void takeSeats(){
        System.out.println("Taking seats");
    }

    public void applause(){
        System.out.println("CLAP CLAP CLAP");
    }

    public void demandRefund(){
        System.out.println("Demanding a refund");
    }

    /**环绕通知**/
    public void watchPerformance(ProceedingJoinPoint jp){
        try{
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP");
//            throw new RuntimeException("FUCK U");
        }catch (Throwable e){
            System.out.println("Demanding a refund");
        }
    }
}
