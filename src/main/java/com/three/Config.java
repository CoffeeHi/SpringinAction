package com.three;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * Created by 陈祥 on 2016/8/17.
 */
@Configuration
public class Config {

    @Bean
    @Qualifier("cake")
//    @Primary
    public Dessert Cake(){
        return new Cake();
    }

    @Bean
    public Dessert Cookie(){
        return new Cookie();
    }

    @Bean
    public Dessert IceCream(){
        return new IceCream();
    }
}
