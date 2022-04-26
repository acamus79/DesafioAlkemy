package com.acamus.disney.services;

import com.acamus.disney.dto.GenreDTO;
import java.util.List;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
public interface GenreService {

    public GenreDTO save(GenreDTO dto);

    public List<GenreDTO> getAllGenre();

    public void deletedGenreByid(Long id);

    public GenreDTO editGenreById(Long id, GenreDTO genreToEdit);
}
