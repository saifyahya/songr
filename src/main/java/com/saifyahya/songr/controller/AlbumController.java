package com.saifyahya.songr.controller;

import com.saifyahya.songr.model.Album;
import com.saifyahya.songr.repositores.AlbumRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;



@Controller
public class AlbumController {

    // constructor injection of a bean of AlbumRepo
    final AlbumRepo albumRepository;
    public AlbumController(AlbumRepo albumRepository) {
        this.albumRepository=albumRepository;
    }
    @GetMapping("/albums")
    public String getAlbums(Model m){
        List<Album> albumsList = albumRepository.findAll();
        m.addAttribute("album",albumsList);
        return "albums.html";
    }

    @PostMapping("/create-album")
    public RedirectView createAlbum(String title, String artist,  String songCount,  String lengthInSecond, String imageUrl) {
       try {
           Integer integerSongCount = Integer.parseInt(songCount);

           Integer integerLength = Integer.parseInt(lengthInSecond);
           Album newAlbum = new Album(title, artist, integerSongCount, integerLength, imageUrl);
           albumRepository.save(newAlbum);
           return new RedirectView("/albums");
       }

       catch (NumberFormatException e) {
           System.out.println("Error in parsing new album: "+e);;
           return new RedirectView("/albums");
       }

    }
    @GetMapping("/album")
    public String getAlbum(Model m,String title){
        Album album = albumRepository.findByTitle(title);
        if(album!=null) {
        m.addAttribute("album",album);
        return "album.html";}
        else
            return "albums.html";
    }
    @DeleteMapping("/delete-album/{albumId}")
    public RedirectView deleteAlbum(@PathVariable Long albumId) {
        albumRepository.deleteById(albumId);
        return new RedirectView("/albums");
    }

}
