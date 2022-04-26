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

    @GetMapping("/details/{id}")
    public ResponseEntity<CharacterDTO> getDetailsById(@PathVariable Long id) {
        CharacterDTO charDetails = characterSevice.getCharDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(charDetails);
    }

    //Save Character
    @PostMapping
    public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO dto) {
        CharacterDTO charSave = characterSevice.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(charSave);
    }

    //Update for id
    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> editCharacter(@PathVariable Long id, @RequestBody CharacterDTO charToEdit) {
        CharacterDTO editedChar = characterSevice.editCharacterById(id, charToEdit);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedChar);
    }

    //delete for id Soft-delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        characterSevice.deleteCharacterById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

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
