package com.saifyahya.songr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Song {
    public Song(String title, Integer lengthInSeconds, Integer trackNumber, Album album) {
        this.title = title;
        this.lengthInSeconds = lengthInSeconds;
        this.trackNumber = trackNumber;
        this.album = album;}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer lengthInSeconds;
    private Integer trackNumber;
@ManyToOne
    private Album album;
}
