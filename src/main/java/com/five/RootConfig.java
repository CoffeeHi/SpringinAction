package com.five;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;

/**
 * Created by 陈祥 on 2016/8/23.
 */
@Configuration
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {

    @Bean //配置国际化信息源
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean //配置Tiles视图解析器
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions(new String[]{
                "/WEB-INF/layout/tiles.xml"
        });
        tiles.setCheckRefresh(true);
        return tiles;
    }

    @Bean
    public ViewResolver viewResolver(){
        return new TilesViewResolver();
    }
}
