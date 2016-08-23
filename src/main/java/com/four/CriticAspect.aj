package com.four;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * Created by 陈祥 on 2016/8/23.
 * 使用AspectJ实现表演的评论员
 */
public aspect CriticAspect {
    public CriticAspect() {
    }

    pointcut performance() : execution(* perform(..));

    after()  returning : performance(){
        System.out.println(criticismEngine.getCriticism());
    }

    private CriticismEngine criticismEngine;

    //注入CriticismEngine
    public void setCriticismEngine(CriticismEngine criticismEngine){
        this.criticismEngine = criticismEngine;
    }
}
