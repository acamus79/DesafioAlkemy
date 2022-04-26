package com.acamus.disney.services.impl;

import com.acamus.disney.dto.MovieBasicDTO;
import com.acamus.disney.dto.MovieDTO;
import com.acamus.disney.entities.Movie;
import com.acamus.disney.exception.ParamNotFound;
import com.acamus.disney.mappers.MovieMapper;
import com.acamus.disney.repositories.MovieRepo;
import com.acamus.disney.services.CharacterService;
import com.acamus.disney.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieMapper movieMap;

    @Autowired
    MovieRepo movieRepo;
    
    @Autowired
    CharacterService characterServ;

    @Override
    public MovieDTO save(MovieDTO dto) {
        Movie entity = movieRepo.save(movieMap.dto2Entity(dto));
        MovieDTO dtoResult = movieMap.entity2DTO(entity, false);
        return dtoResult;
    }

    @Override
    public List<MovieBasicDTO> getAll() {
        List<Movie> entities = movieRepo.findAll();
        List<MovieBasicDTO> result = movieMap.entityList2BasicDTOList(entities);
        return result;
    }

    @Override
    public MovieDTO update(String id, MovieDTO dto) {

        Movie movie = this.findById(id);
        movie.setImage(dto.getImage());
        movie.setTitle(dto.getTitle());
        movie.setRating(dto.getRating());
        movie.setCreationDate(movieMap.string2LocalDate(dto.getCreationDate()));

        Movie editedMovie = movieRepo.save(movie);

        MovieDTO resultDTO = movieMap.entity2DTO(movie, false);
        return resultDTO;
    }

    @Override
    public void delete(String id) {
        movieRepo.delete(this.findById(id));

    }

    @Override
    public void addCharacter(String id, Long idCharacter) {
        Movie movie = this.findById(id);
        
    }

    @Override
    public void removeCharacter(String id, Long idCharacter) {

    }

    @Override
    public void addGenre(String id, Long idGenre) {

    }

    @Override
    public void removeGenre(String id, Long idGenre) {

    }

    @Override
    public MovieDTO getDetails(String id) {
        return null;
    }

    @Override
    public List<MovieDTO> getByFilters(String title, Set<Long> genres, String order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Movie findById(String id) {
        Optional<Movie> op = movieRepo.findById(id);
        if (!op.isPresent())
        {
            throw new ParamNotFound("No Movie for id: " + id);
        }
        return op.get();
    }
}
