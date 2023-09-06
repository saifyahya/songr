package com.saifyahya.songr.repositores;

import com.saifyahya.songr.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepo extends JpaRepository<Album,Long> {
    Album findByTitle(String title);
}
