package com.three;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by 陈祥 on 2016/8/17.
 */
@Component
public class Cookie implements Dessert {
    public Cookie() {
        System.out.println("I'm cookie!");
    }
}
