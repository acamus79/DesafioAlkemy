package com.acamus.disney.mappers;

import com.acamus.disney.dto.CharacterDTO;
import com.acamus.disney.dto.CharacterBasicDTO;
import com.acamus.disney.entities.Character;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Component
public class CharacterMapper {


    @Autowired
    MovieMapper movieMapper;

    public Character dto2Entity(CharacterDTO dto){
        Character entity = new Character();
        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setHistory(dto.getHistory());
        return entity;
    }

    public CharacterDTO entity2DTO(Character entity, boolean flag){
        CharacterDTO dto = new CharacterDTO();
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setHistory(entity.getHistory());
        if (flag){
            dto.setPeliculas(movieMapper.entityList2DTOList(entity.getPeliculas()));
        }
        return dto;
    }

    public List<CharacterDTO> entityList2DTOList(List<Character> entities, boolean flag){
        List<CharacterDTO> dtos = new ArrayList<>();
        for (Character entity: entities){
            dtos.add(this.entity2DTO(entity,flag));
        }
        return dtos;
    }
    
    
    public CharacterBasicDTO entity2BasicDTO(Character entity){
        CharacterBasicDTO dto = new CharacterBasicDTO();
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        return dto;
    }

    
    public List<CharacterBasicDTO> entityList2BasicDTOList(List<Character> entities){
        List<CharacterBasicDTO> dtos = new ArrayList<>();
        for (Character aux: entities){
            dtos.add(this.entity2BasicDTO(aux));
        }
        return dtos;
    }
    

}
