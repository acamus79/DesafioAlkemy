package com.acamus.disney.services;

import com.acamus.disney.dto.CharacterDTO;
import java.util.List;
import java.util.Set;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
public interface CharacterService {

    public CharacterDTO save(CharacterDTO dto);

    public List<CharacterDTO> getAllCharacter();

    public CharacterDTO getCharDetails(Long id);

    public CharacterDTO editCharacterById(Long id, CharacterDTO charToEdit);

    public void deleteCharacterById(Long id);

    public List<CharacterDTO> getByFilters(String name, Integer age, Set<String> movies);

}
