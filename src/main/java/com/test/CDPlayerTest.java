package com.test;

import com.bean.CDPlayer;
import com.configbean.CDPlayerConfig;
import com.configbean.SoundSystemConfig;
import com.inte.CompactDisc;
import com.inte.MediaPlayer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by 陈祥 on 2016/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes= CDPlayerConfig.class)
@ContextConfiguration(classes= SoundSystemConfig.class)
public class CDPlayerTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("cd.xml");
        CDPlayer player = context.getBean(CDPlayer.class);
        player.play();
        context.close();
    }
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);
    }

    @Test
    public void play(){
        player.play();
//        System.out.println(log.getLog());
        assertEquals("playing Duang by The Beatles\n", log.getLog());
    }

}
