package com.configbean;

import com.bean.CDPlayer;
import com.inte.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by 陈祥 on 2016/8/17.
 */
@Configuration
//@ComponentScan(basePackages = "com.bean")
//@ComponentScan(basePackageClasses = CDPlayer.class)
@Import(CDConfig.class)
public class CDPlayerConfig {

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }
}
