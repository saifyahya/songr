package com.saifyahya.songr.controller;

import com.saifyahya.songr.model.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
@Controller
public class AlbumController {
    @GetMapping("/albums")
    public String show3Albums(Model m) {
        Album album1 = new Album("RAP","50Cent",50000,300,"https://i.ytimg.com/vi/QOx-myL1GXY/maxresdefault.jpg");
       Album album2 = new Album("Dabkeh","Sharhabel",12000,900,"https://www.zamantours.com/wp-content/uploads/2020/04/Dancing-traditional-dance-Dabke.jpg");
        Album album3 = new Album("LO","Saif",40000,400,"https://i.scdn.co/image/ab67616d0000b2732edb3eebc2401d7fc6d5722d");
       Album[] albumArray = new Album[3];
        albumArray[0]=album1;
       albumArray[1]=album2;
       albumArray[2]=album3;
       m.addAttribute("album",albumArray);
        return "albums.html";
    }
}
