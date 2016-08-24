package com.five;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
@Component
public class SpitterRepository {
    public Spitter save(Spitter unsaved) {
        return null;
    }

    public Spitter findByUsername(String username) {
        return new Spitter(24L, "jbauer" , "24hours" , "Jack" , "Bauer");
    }
}
