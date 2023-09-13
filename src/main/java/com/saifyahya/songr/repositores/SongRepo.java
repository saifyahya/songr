package com.saifyahya.songr.repositores;

import com.saifyahya.songr.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<Song,Long> {

    Song findByTitle(String title);
}
