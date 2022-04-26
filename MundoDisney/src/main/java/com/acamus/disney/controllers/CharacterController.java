package com.acamus.disney.controllers;

import com.acamus.disney.dto.CharacterDTO;
import com.acamus.disney.services.CharacterService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    CharacterService characterSevice;

    //All Characters
    @GetMapping("/all")
    public ResponseEntity<List<CharacterDTO>> getAllChart() {
        List<CharacterDTO> charDTOs = characterSevice.getAllCharacter();
        return ResponseEntity.ok().body(charDTOs);
    }

    @GetMapping("/details/{characterId}")
    public ResponseEntity<CharacterDTO> getDetailsById(@PathVariable Long characterId) {
        CharacterDTO charDetails = characterSevice.getCharDetails(characterId);
        return ResponseEntity.status(HttpStatus.OK).body(charDetails);
    }

    //Save Character
    @PostMapping
    public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO dto) {
        CharacterDTO charSave = characterSevice.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(charSave);
    }
 
    /**
     * Update for id
     * @param characterId
     * @param charToEdit
     * @return 
     */
    @PutMapping("/{characterId}")
    public ResponseEntity<CharacterDTO> editCharacter(@PathVariable Long characterId, @RequestBody CharacterDTO charToEdit) {
        CharacterDTO editedChar = characterSevice.editCharacterById(characterId, charToEdit);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedChar);
    }

    
    /**
     * Delete for id
     * @param characterId
     * @return ResponseEntity
     */
    @DeleteMapping("/delete/{characterId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long characterId) {
        characterSevice.deleteCharacterById(characterId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    /**
     * Filters
     * @param name
     * @param age
     * @param movies
     * @return 
     */
    @GetMapping()
    public ResponseEntity<List<CharacterDTO>> getDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Set<String> movies
    ) {
        List<CharacterDTO> charList = characterSevice.getByFilters(name, age, movies);
        return ResponseEntity.status(HttpStatus.OK).body(charList);

    }

}
