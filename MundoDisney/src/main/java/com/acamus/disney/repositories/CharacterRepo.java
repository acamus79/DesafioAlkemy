package com.acamus.disney.repositories;

import com.acamus.disney.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepo extends JpaRepository<Character, Long>, JpaSpecificationExecutor<Character> {
    
}
