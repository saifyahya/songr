package com.saifyahya.songr.controller;

import com.saifyahya.songr.model.Album;
import com.saifyahya.songr.repositores.AlbumRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;


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
    @GetMapping("/update-album")
    public String updateAlbumForm(){
        return "update-album.html";
    }
    @PostMapping("/update-album")
    public RedirectView saveUpdatedAlbum(Long id,String title, String artist,  String songCount,  String lengthInSecond, String imageUrl) {
            try {
                Optional<Album> albumFromRepo = albumRepository.findById(id);  // optional type tha holds data or null from find byId method
                if (albumFromRepo.isPresent()) {  // if the album exists in DB
                    Album albumToUpdate = albumFromRepo.get();
                Integer integerSongCount = Integer.parseInt(songCount);

                Integer integerLength = Integer.parseInt(lengthInSecond);

                if (!title.equals(""))
                    albumToUpdate.setTitle(title);
                if (!artist.equals(""))
                    albumToUpdate.setArtist(artist);
                if (integerSongCount!=null)
                    albumToUpdate.setSongCount(integerSongCount);
                if (integerLength!=null)
                    albumToUpdate.setLengthInSecond(integerLength);
                if (!imageUrl.equals(""))
                    albumToUpdate.setImageUrl(imageUrl);
                albumRepository.save(albumToUpdate);   //saving the updated album to database
            } else{
                return new RedirectView("/update-album"); //  this will trigger the getMapping for the given path

        }
    }catch(NumberFormatException e){
                System.out.println("Error in parsing updated album: "+e);;
                return new RedirectView("/albums");
            }
        return new RedirectView("/albums");   // if updated done successfully
    }

    @DeleteMapping("/delete-album/{albumId}")
    public RedirectView deleteAlbum(@PathVariable Long albumId) {
        albumRepository.deleteById(albumId);
        return new RedirectView("/albums");
    }

}
