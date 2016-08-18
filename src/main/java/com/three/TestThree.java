package com.three;

import com.bean.BlankDisc;
import com.configbean.SoundSystemConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by 陈祥 on 2016/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {Config.class, ExpressiveConfig.class})
public class TestThree {


    private Dessert dessert1;
    private Dessert dessert2;

    @Autowired
//    @Qualifier("cake")
    @Cold
    @Creamy
    public void setDessert1(Dessert dessert1) {
        this.dessert1 = dessert1;
    }

    @Autowired
//    @Qualifier("cake")
    @Cold
    @Creamy
    public void setDessert2(Dessert dessert2) {
        this.dessert2 = dessert2;
    }

    @Autowired
    private BlankDisc disc;

    @Test
    public void test(){
        assertNotNull(dessert1);
        assertEquals(dessert1.getClass(), IceCream.class);
        assertEquals(dessert1.hashCode(), dessert2.hashCode());//证明是单例
//        assertEquals(disc.getTitle(), "北京欢迎你");
//        assertEquals(disc.getArtist(), "群星");
        System.out.println("\n" + disc.getArtist() + "\n" + disc.getTitle() + "\n" + disc.getConnectionCount());
    }
}
