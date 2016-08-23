package com.five;

import java.util.List;

/**
 * Created by 陈祥 on 2016/8/23.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
