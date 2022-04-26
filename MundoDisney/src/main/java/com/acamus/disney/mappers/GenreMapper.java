package com.acamus.disney.mappers;

import com.acamus.disney.dto.GenreDTO;
import com.acamus.disney.entities.Genre;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Component
public class GenreMapper {

    @Autowired
    MovieMapper movieMapper;

    public Genre dto2Entity(GenreDTO dto) {
        Genre entity = new Genre();
        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        return entity;
    }

    public GenreDTO entity2Dto(Genre entity, boolean flag) {
        GenreDTO dto = new GenreDTO();
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        if (flag)
        {
            dto.setGenreMovies(movieMapper.entityList2DTOList(entity.getGenreMovies()));
        }
        return dto;
    }

    public List<GenreDTO> entityList2DTOList(List<Genre> GenreList, boolean b) {
        List<GenreDTO> dtos = new ArrayList<>();
        GenreList.forEach(entity ->
        {
            dtos.add(this.entity2Dto(entity, false));
        });
        return dtos;
    }
}
