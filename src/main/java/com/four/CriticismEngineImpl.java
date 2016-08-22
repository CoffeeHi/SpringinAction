package com.four;

/**
 * Created by Administrator on 2016/8/22 0022.
 * 要注入到CriticAspect中的CriticismEngine实现
 */
public class CriticismEngineImpl implements CriticismEngine {

    private String [] criticismPool;

    public CriticismEngineImpl() {
    }

    public String getCriticism() {
        int i = (int)(Math.random() * criticismPool.length);
        return criticismPool[i];
    }

    public void setCriticismPool(String[] criticismPool){
        this.criticismPool = criticismPool;
    }
}
