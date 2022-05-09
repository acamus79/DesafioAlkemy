package com.acamus.disney.mappers;

import com.acamus.disney.dto.MovieBasicDTO;
import com.acamus.disney.dto.MovieDTO;
import com.acamus.disney.entities.Movie;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Component
public class MovieMapper {

    @Autowired
    CharacterMapper characterMapper;

    @Autowired
    GenreMapper genreMapper;

    public Movie dto2Entity(MovieDTO dto) {

        Movie film = new Movie();
        film.setCreationDate(this.string2LocalDate(dto.getCreationDate()));
        film.setTitle(dto.getTitle());
        film.setImage(dto.getImage());

        return film;
    }
    
    public MovieDTO entity2DTO(Movie film, boolean flag) {
        MovieDTO dto = new MovieDTO();
        dto.setImage(film.getImage());
        dto.setTitle(film.getTitle());
        dto.setRating(film.getRating());

        dto.setCreationDate(this.localDate2String(film.getCreationDate()));

        if (flag)
        {
            dto.setPersonajesDTO(this.characterMapper.entityList2DTOList(film.getPersonajes(), false));
            dto.setGenerosDTO(this.genreMapper.entityList2DTOList(film.getGeneros(), false));
        }
        return dto;

    }

    public MovieBasicDTO entity2BasicDTO(Movie film) {
        MovieBasicDTO basicDTO = new MovieBasicDTO();

        basicDTO.setCreationDate(film.getCreationDate());
        basicDTO.setImage(film.getImage());
        basicDTO.setTitle(film.getTitle());

        return basicDTO;
    }

    public List<MovieBasicDTO> entityList2BasicDTOList(List<Movie> movieList) {

        List<MovieBasicDTO> dtos = new ArrayList<>();

        for (Movie entity : movieList)
        {
            dtos.add(this.entity2BasicDTO(entity));
        }
        return dtos;
    }

    public List<MovieDTO> entityList2DTOList(List<Movie> movieList) {

        List<MovieDTO> dtos = new ArrayList<>();

        for (Movie entity : movieList)
        {
            dtos.add(this.entity2DTO(entity, true));
        }
        return dtos;
    }

    public List<Movie> dtoList2EntityList(List<MovieDTO> dtoMovies, boolean flag) {
        List<Movie> movies = new ArrayList<>();

        for (MovieDTO aux : dtoMovies)
        {
            movies.add(this.dto2Entity(aux));
        }
        return movies;
    }

    /**
     *
     * @param dateString
     * @return LocalDate
     */
    public LocalDate string2LocalDate(String dateString) {
        DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateString, dtm);
    }

    /**
     *
     * @param LocalDate
     * @return String
     */
    public String localDate2String(LocalDate date) {
        String stringDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return stringDate;
    }

}
