package com.saifyahya.songr.controller;

import com.saifyahya.songr.model.Album;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
@Controller
public class AlbumController {
    @ResponseBody
    @GetMapping("/albums")
    public String show3Albums() {
        Album album1 = new Album("RAP","50Cent",50000,300,"any");
       Album album2 = new Album("Dabkeh","Sharhabel",12000,900,"any");
        Album album3 = new Album("LO","Saif",40000,400,"any");
       String[] albumArray = new String[3];
        albumArray[0]=album1.getTitle();
       albumArray[1]=album2.getTitle();
       albumArray[2]=album3.getTitle();
        String result = Arrays.toString(albumArray);
        return "Albums category: "+result;
    }
}
