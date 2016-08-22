package com.bean;

import com.inte.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * Created by 陈祥 on 2016/8/17.
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Duang";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("playing " + title + " by " + artist);
    }

    public void playTrack(int trackNumber) {

    }
}
