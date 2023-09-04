package com.saifyahya.songr.model;

public class Album {
    protected String title;
    protected String artist;
    protected int songCount;
    protected int lengthInSecond;
    protected String imageUrl;

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

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    // getters
    public String getTitle() {
        return title;
    }

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
}
