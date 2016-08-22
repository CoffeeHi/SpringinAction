package com.bean;

import com.inte.Quest;

import java.io.PrintStream;

/**
 * Created by 陈祥 on 2016/8/17.
 */
public class SlayDragonQuest implements Quest {

    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark(){
        stream.println("Embarking on quest to slay the dragon!");
    }
}
