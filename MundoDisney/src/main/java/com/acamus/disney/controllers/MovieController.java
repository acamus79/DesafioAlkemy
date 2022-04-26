
package com.acamus.disney.controllers;

import com.acamus.disney.dto.MovieBasicDTO;
import com.acamus.disney.dto.MovieDTO;
import com.acamus.disney.services.MovieService;
import java.util.List;
import java.util.Set;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService mService;
    
    /**
     * Get list for all movies
     * @return ResponseEntity and Movie List
     */
    @GetMapping("/all")
    public ResponseEntity<List<MovieBasicDTO>> getAllMovie(){
        List<MovieBasicDTO> moviesList = mService.getAll();
        return ResponseEntity.ok().body(moviesList);
    }
    
    /**
     * 
     * @param String id
     * @return ResponseEntity
     */
    @GetMapping("/details/{movieId}")
    public ResponseEntity<MovieDTO> getDetailsById(@PathVariable String id){
        MovieDTO movie = mService.getDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }
    
    /**
     * 
     * @param dto
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO dto){
        MovieDTO movieSave = mService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieSave);
    }
    
    /**
     * 
     * @param movieId
     * @param charId
     * @return ResponseEntity
     */
    @PostMapping("/{movieId}/character/{charId}")
    public ResponseEntity<Void> addChar(@PathVariable String movieId, @PathVariable Long charId){
        mService.addCharacter(movieId, charId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 
     * @param movieId
     * @param genreId
     * @return ResponseEntity
     */
    @PostMapping("/{movieId}/genre/{genreId}")
    public ResponseEntity<Void> addGenre(@PathVariable String movieId, @PathVariable Long genreId){
        mService.addGenre(movieId, genreId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 
     * @param id
     * @param movieToEdit
     * @return ResponseEntity
     */
    @PutMapping("/{movieId}")
    public ResponseEntity<MovieDTO> editMovie(@PathVariable String id, @RequestBody MovieDTO movieToEdit){
        MovieDTO editedMovie = mService.update(id, movieToEdit);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedMovie);
    }

    /**
     * Delete Movie by id
     * @param String id
     * @return ResponseEntity
     */
    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        mService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * Filters
     * @param title
     * @param genre
     * @param order
     * @return 
     */
    @GetMapping
    public ResponseEntity<List<MovieDTO>> getDetailsByFilters(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Set<Long> genre,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){
        List<MovieDTO> filteredMovies = mService.getByFilters(title, genre, order);
        return ResponseEntity.status(HttpStatus.OK).body(filteredMovies);
    }
    
    
    
}
