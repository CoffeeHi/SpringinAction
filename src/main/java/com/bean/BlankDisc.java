package com.bean;

import com.inte.CompactDisc;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 陈祥 on 2016/8/17.
 */
@Data
@Component
@Primary
public class BlankDisc implements CompactDisc{

    private String title;
    private String artist;
    private List<String> tracks;
    private int connectionCount;

    public BlankDisc() {
    }

    public BlankDisc( String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public BlankDisc(@Value("${disc.title}") String title, @Value("${disc.artist}") String artist, List<String> tracks, int connectionCount) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
        this.connectionCount = connectionCount;
    }

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public BlankDisc(int connectionCount, String artist, String title) {
        this.connectionCount = connectionCount;
        this.artist = artist;
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (String track : tracks){
            System.out.println("-Track: " + track);
        }
    }

    public void playTrack(int trackNumber) {
//        System.out.println("Playing " + title + " by " + artist);
            System.out.println("-Track: " + tracks.get(trackNumber));
    }


}
