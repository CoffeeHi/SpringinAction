package com.configbean;

import com.bean.BraveKnight;
import com.bean.SlayDragonQuest;
import com.inte.Knight;
import com.inte.Quest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 陈祥 on 2016/8/17.
 */
@Configuration
public class KnightConfig {

    @Bean
    public Knight knight(){
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest(){
        return new SlayDragonQuest(System.out);
    }
}
