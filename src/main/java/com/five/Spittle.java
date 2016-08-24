package com.five;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Created by 陈祥 on 2016/8/23.
 * Spittle类 包含消息内容、时间戳和位置信息
 */
@Data
public class Spittle {
    private Long id;
    private final String message;
    private final Date time;
    private Double latitude;
    private Double longtitude;

    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }

    public Spittle(String message, Date time, Double latitude, Double longtitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

/*    public Long getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }*/

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }
}
