package com.bean;

import com.inte.Knight;
import com.inte.Quest;

/**
 * Created by 陈祥 on 2016/8/17.
 */
public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest(){
        quest.embark();
    }
}
