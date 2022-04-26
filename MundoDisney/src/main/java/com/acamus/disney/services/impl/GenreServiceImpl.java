package com.acamus.disney.services.impl;

import com.acamus.disney.dto.GenreDTO;
import com.acamus.disney.entities.Genre;
import com.acamus.disney.exception.ParamNotFound;
import com.acamus.disney.mappers.GenreMapper;
import com.acamus.disney.repositories.GenreRepo;
import com.acamus.disney.services.GenreService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreMapper genreMapper;

    @Autowired
    GenreRepo genreRepository;

    @Override
    public GenreDTO save(GenreDTO dto) {
        Genre entity = genreMapper.dto2Entity(dto);
        Genre savedEntity = genreRepository.save(entity);
        GenreDTO result = genreMapper.entity2Dto(savedEntity, false);
        return result;
    }

    @Override
    public List<GenreDTO> getAllGenre() {
        List<Genre> entities = genreRepository.findAll();
        List<GenreDTO> result = this.genreMapper.entityList2DTOList(entities, false);
        return result;
    }

    @Override
    public void deletedGenreByid(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public GenreDTO editGenreById(Long id, GenreDTO genreToEdit) {
        Genre savedGenre = this.handleFindById(id);
        savedGenre.setImage(genreToEdit.getImage());
        savedGenre.setName(genreToEdit.getName());
        Genre editedGenre = genreRepository.save(savedGenre);
        GenreDTO resultDTO = genreMapper.entity2Dto(editedGenre, false);
        return resultDTO;
    }

    public Genre handleFindById(Long id) {
        Optional<Genre> toBeFound = genreRepository.findById(id);
        if (!toBeFound.isPresent())
        {
            throw new ParamNotFound("No Genre for id: " + id);
        }
        return toBeFound.get();
    }
}
