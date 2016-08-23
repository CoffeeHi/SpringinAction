package com.four;

import com.inte.CompactDisc;
import com.three.Config;
import com.three.ExpressiveConfig;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by 陈祥 on 2016/8/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = ConcertConfig.class)
@ContextConfiguration(locations = {"classpath:aspect.xml"})
public class TestAspect {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private CompactDisc cd;

/*    @Autowired
    private TrackCounter counter;*/

    @Autowired
    private TrackCounterXml counter;

    @Autowired
    private Performance performance;

    @Test
    public void test(){
        performance.perform();
        ((Encoreable)performance).performEncore();
    }

    @Test
    public void testTrackCounter(){
        //播放一些磁道
        cd.playTrack(1);

        cd.playTrack(2);
        cd.playTrack(2);

        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);

        cd.playTrack(4);
        cd.playTrack(4);

        cd.playTrack(5);
        cd.playTrack(5);
        cd.playTrack(5);
        cd.playTrack(5);

        //断言期望的数量
        assertEquals(0, counter.getPlayCount(0));
        assertEquals(1, counter.getPlayCount(1));
        assertEquals(2, counter.getPlayCount(2));
        assertEquals(5, counter.getPlayCount(3));
        assertEquals(2, counter.getPlayCount(4));
        assertEquals(4, counter.getPlayCount(5));
    }
}
