package com.four;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by Administrator on 2016/8/22 0022.
 * 通过注解引入新功能
 */
@Aspect
public class EncoreableIntroducer {
    @DeclareParents(value = "com.four.Performance+" , defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
