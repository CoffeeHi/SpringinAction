package com.three;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by 陈祥 on 2016/8/17.
 */
@Component
@Cold
@Creamy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class IceCream implements Dessert{
    public IceCream() {
        System.out.println("I'm icecream!");
    }
}
