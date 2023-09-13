package com.saifyahya.songr.controller;

import com.saifyahya.songr.exceptions.AlbumNotFoundException;
import com.saifyahya.songr.model.Album;
import com.saifyahya.songr.model.Song;
import com.saifyahya.songr.repositores.AlbumRepo;
import com.saifyahya.songr.repositores.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Controller
public class SongController {
    final SongRepo songRepository;
    final AlbumRepo albumRepository;

    @Autowired
    public SongController(SongRepo songRepository, AlbumRepo albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @PostMapping("/addSong")
    public RedirectView addSong(String title, String lengthInSeconds, String trackNumber, Long albumId) {
        try {
            Album album = albumRepository.findById(albumId).get();
            if (album == null)
                throw new AlbumNotFoundException("Could not find stand with name");
            Integer integerTrackNumber = Integer.parseInt(trackNumber);

            Integer integerLength = Integer.parseInt(lengthInSeconds);
            Song song = new Song(title, integerLength, integerTrackNumber, album);
            songRepository.save(song);
        } catch (NumberFormatException e) {
            System.out.println("Error in parsing new song to the album: " + e);
            ;
            return new RedirectView("/albums");
        }
        return new RedirectView("/albums");
    }

    @GetMapping("/songs")
    public String getAllSongs(Model m) {
        List<Song> songs = songRepository.findAll();
        if (songs == null)
            throw new NoSuchElementException("No Songs Available");
        m.addAttribute("songs", songs);
        return "songs.html";
    }

    @GetMapping("/songs-in-album/{albumId}")
    public String songsInAlbum(Model m, @PathVariable Long albumId) {
        Album album = albumRepository.findById(albumId).get();
        m.addAttribute("album", album);
        return "songs-in-album.html";
    }

    @DeleteMapping("/delete-song/{songId}/{albumId}")
    public RedirectView deleteSong(@PathVariable Long songId,@PathVariable Long albumId) {
        songRepository.deleteById(songId);
        return new RedirectView("/songs-in-album/" + albumId);
    }

    @GetMapping("/update-song/{songId}")
    public String updateSongForm(Model m,@PathVariable Long songId) {
        m.addAttribute("songId",songId);
                return"update-song.html";
    }
    @PostMapping("/update-song")
        public RedirectView updateSong(Long id, String title, String lengthInSeconds, String trackNumber) {
            try{
                Optional<Song> mySong = songRepository.findById(id);
                    if(mySong.isPresent()) {
                        Song song= mySong.get();
                        Integer integerLength= Integer.parseInt(lengthInSeconds);
                        Integer integerTrackNumber=Integer.parseInt(trackNumber);
                    if(!title.equals(""))
                        song.setTitle(title);
                        if(integerTrackNumber!=null)
                            song.setTrackNumber(integerTrackNumber);
                        if(integerLength!=null)
                            song.setLengthInSeconds(integerLength);
                        songRepository.save(song);
                    }
                    else{
                        return new RedirectView("/update-song/"+id);  //this must be handled via extra template
                    }
            }catch(NumberFormatException e){
                System.out.println("Error in parsing updated song: "+e);;
                return new RedirectView("/songs-in-album/"+id);             //this must be handled via extra template
            }
        return new RedirectView("/albums");

    }
    @GetMapping("/song")
    public String getSong(Model m,String title){
        Song song = songRepository.findByTitle(title);
        if(song!=null) {
            m.addAttribute("song",song);
            return "song.html";}
        else
            return "songs.html";
    }

}
