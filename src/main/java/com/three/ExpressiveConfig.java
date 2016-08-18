package com.three;

import com.bean.BlankDisc;
import com.bean.CDPlayer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * Created by 陈祥 on 2016/8/18.
 */
@Configuration
@PropertySource("app.properties")
@ComponentScan(basePackageClasses = {CDPlayer.class})
@Data
public class ExpressiveConfig {

    /*@Autowired
    Environment env;

    @Bean
    public BlankDisc disc(){
        return new BlankDisc(
                env.getProperty("db.connection.count", Integer.class, 40),
                env.getProperty("disc.title", "defaultTitle"),
                env.getProperty("disc.artist", "defaultArtist")
        );
    }*/

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
