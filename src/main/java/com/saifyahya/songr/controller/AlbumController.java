package com.saifyahya.songr.controller;

import com.saifyahya.songr.model.Album;
import com.saifyahya.songr.repositores.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class AlbumController {

    @Autowired
    AlbumRepo albumRepository;
    /* @GetMapping("/albums")
    *public String show3Albums(Model m) {
         Album album1 = new Album("RAP","50Cent",50000,300,"https://i.ytimg.com/vi/QOx-myL1GXY/maxresdefault.jpg");
        Album album2 = new Album("Dabkeh","Sharhabel",12000,900,"https://www.zamantours.com/wp-content/uploads/2020/04/Dancing-traditional-dance-Dabke.jpg");
         Album album3 = new Album("LO","Saif",40000,400,"https://i.scdn.co/image/ab67616d0000b2732edb3eebc2401d7fc6d5722d");
        Album[] albumArray = new Album[3];
         albumArray[0]=album1;
        albumArray[1]=album2;
        albumArray[2]=album3;
        m.addAttribute("album",albumArray);
         return "albums.html";
     }*/
    @GetMapping("/albums")
    public String getAlbums(Model m){
        List<Album> albumsList = albumRepository.findAll();
        m.addAttribute("album",albumsList);
        return "albums.html";
    }
    @PostMapping("/create-album")
    public RedirectView createAlbum(String title, String artist, Integer songCount, Integer lengthInSecond, String imageUrl) {
Album newAlbum = new Album(title, artist, songCount, lengthInSecond, imageUrl);

albumRepository.save(newAlbum);
return new RedirectView("/albums");
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
    public RedirectView deleteAlbum(@RequestParam Long albumId) {
        albumRepository.deleteById(albumId);
        return new RedirectView("/albums");
    }

}
