package com.three;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by 陈祥 on 2016/8/17.
 */
@Component
//@Qualifier("cake")
public class Cake implements Dessert {
    public Cake() {
        System.out.println("I'm cake!");
    }
}
