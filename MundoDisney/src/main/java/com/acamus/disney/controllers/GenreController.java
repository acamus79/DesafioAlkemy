package com.acamus.disney.controllers;

import com.acamus.disney.dto.GenreDTO;
import com.acamus.disney.services.GenreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@RestController
@RequestMapping("genres")
public class GenreController {
    
    @Autowired
    GenreService genreService;
    //All Genre
    @GetMapping("/all")
    public ResponseEntity<List<GenreDTO>> getAll(){
        List<GenreDTO> genres = genreService.getAllGenre();
        return ResponseEntity.ok().body(genres);
    }
    //Save Genre
    @PostMapping
    public ResponseEntity<GenreDTO> save(@RequestBody GenreDTO dto){
        GenreDTO genreSave = genreService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(genreSave);
    }
    @PutMapping("/{id}")
    public ResponseEntity<GenreDTO> editGenre(@PathVariable Long id, @RequestBody GenreDTO genreToEdit){
        GenreDTO editedGenre = genreService.editGenreById(id, genreToEdit);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedGenre);
    }

    // --- DELETE ---
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        genreService.deletedGenreByid(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
