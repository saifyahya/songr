package com.saifyahya.songr.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Album {
    public Album() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String title;
    protected String artist;

    protected Integer songCount;

    protected Integer lengthInSecond;
    protected String imageUrl;
    @OneToMany(mappedBy = "album" ,  cascade = CascadeType.ALL)
    protected List<Song> songs;


    public Album(String title, String artist, int songCount, int lengthInSecond, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.lengthInSecond = lengthInSecond;
        this.imageUrl = imageUrl;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public void setLengthInSecond(int lengthInSecond) {
        this.lengthInSecond = lengthInSecond;
    }
    public void setSongs(List<Song> songs) {this.songs = songs;}


    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    // getters
    public String getTitle() {return title;}
    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public int getLengthInSecond() {
        return lengthInSecond;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Long getId() {
        return id;
    }

    public List<Song> getSongs() {return songs;}
}
