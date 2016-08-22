package com.four;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 陈祥 on 2016/8/22.
 * 无注解的TrackCounter
 */
@Aspect
public class TrackCounterXml {
    private Map<Integer, Integer> trackCounts = new HashMap<Integer, Integer>();

    public void trackPlayed(int trackNumber){}

    /**要声明为前置通知的方法**/
    public void countTrack(int trackNumber){
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber){
        return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
    }
}
