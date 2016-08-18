package com.mains;

import com.inte.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 陈祥 on 2016/8/17.
 */
public class KnightMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("knight.xml");
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.configbean.KnightConfig.class);
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
