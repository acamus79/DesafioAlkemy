package com.acamus.disney.services.impl;

import com.acamus.disney.dto.CharacterDTO;
import com.acamus.disney.dto.CharacterFiltersDTO;
import com.acamus.disney.entities.Character;
import com.acamus.disney.exception.ParamNotFound;
import com.acamus.disney.mappers.CharacterMapper;
import com.acamus.disney.repositories.CharacterRepo;
import com.acamus.disney.repositories.CharacterSpecifications;
import com.acamus.disney.services.CharacterService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterMapper characterMapper;
    @Autowired
    CharacterRepo characterRepository;

    @Autowired
    CharacterSpecifications characterSpec;

    @Override
    public CharacterDTO save(CharacterDTO dto) {
        Character entity = characterMapper.dto2Entity(dto);
        Character saveEntity = characterRepository.save(entity);
        CharacterDTO result = characterMapper.entity2DTO(saveEntity, false);
        return result;
    }

    @Override
    public List<CharacterDTO> getAllCharacter() {
        List<Character> entities = characterRepository.findAll();
        List<CharacterDTO> result = characterMapper.entityList2DTOList(entities, false);
        return result;
    }

    @Override
    public CharacterDTO getCharDetails(Long id) {
        Character dbChar = this.handleFindById(id);
        CharacterDTO resultDTO = characterMapper.entity2DTO(dbChar, true);
        return resultDTO;
    }

    @Override
    public CharacterDTO editCharacterById(Long id, CharacterDTO charToEdit) {
        Character savedChar = this.handleFindById(id);
        savedChar.setImage(charToEdit.getImage());
        savedChar.setName(charToEdit.getName());
        savedChar.setAge(charToEdit.getAge());
        savedChar.setWeight(charToEdit.getWeight());
        savedChar.setHistory(charToEdit.getHistory());
        Character editedChar = characterRepository.save(savedChar);
        CharacterDTO resultDTO = characterMapper.entity2DTO(editedChar, false);
        return resultDTO;
    }

    @Override
    public void deleteCharacterById(Long id) {
        characterRepository.deleteById(id);
    }

    @Override
    public List<CharacterDTO> getByFilters(String name, Integer age, Set<String> movies) {
        CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name, age, movies);
        List<Character> entityList = characterRepository.findAll(characterSpec.getFiltered(filtersDTO));
        List<CharacterDTO> resultDTO = characterMapper.entityList2DTOList(entityList, true);
        return resultDTO;
    }

    // --- ERROR HANDLING ---
    public Character handleFindById(Long id) {
        Optional<Character> toBeFound = characterRepository.findById(id);
        if (!toBeFound.isPresent())
        {
            throw new ParamNotFound("No Character for id: " + id);
        }
        return toBeFound.get();
    }
}
