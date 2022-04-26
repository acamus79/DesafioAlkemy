package com.acamus.disney.services;

import com.acamus.disney.dto.MovieBasicDTO;
import com.acamus.disney.dto.MovieDTO;

import java.util.List;
import java.util.Set;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
public interface MovieService {

    public MovieDTO save(MovieDTO dto);

    public List<MovieBasicDTO> getAll();

    public MovieDTO update(String id, MovieDTO dto);

    public void delete(String id);

    public void addCharacter(String id, Long idCharacter);

    public void removeCharacter(String id, Long idCharacter);

    public void addGenre(String id, Long idGenre);

    public void removeGenre(String id, Long idGenre);

    public MovieDTO getDetails(String id);

    public List<MovieDTO> getByFilters(String title, Set<Long> genres, String order);

}
/*

    Films handleById(String filmsId);

 */