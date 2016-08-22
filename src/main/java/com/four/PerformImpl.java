package com.four;

import org.springframework.stereotype.Component;

/**
 * Created by 陈祥 on 2016/8/22.
 */
@Component
public class PerformImpl implements Performance {
    public void perform() {
        System.out.println("Performing now...");
//        throw new RuntimeException("FUCK");
    }
}
