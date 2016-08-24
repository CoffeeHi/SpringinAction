package com.five;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 陈祥 on 2016/8/24.
 */
@Component
public class SpittleRepositoryImpl implements SpittleRepository {
    public List<Spittle> findSpittles(long max, int count) {
        return createSpittleList(count);
    }

    public Object findOne(long spittleId) {
        Spittle spittle = new Spittle("halo", new Date());
        spittle.setId(spittleId);
        return spittle;
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i=0; i < count; i++){
            Spittle spittle = new Spittle("Spittle " + i, new Date(), 0d+i, 0d+i);
            spittle.setId(0L + i);
            spittles.add(spittle);
        }
        return spittles;
    }
}
