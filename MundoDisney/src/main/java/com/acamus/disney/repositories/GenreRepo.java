/*
 * Sin licencia.
 * Uso para capacitación
 * 2021 Año de la Prevención y Lucha contra el COVID-19.
 */
package com.acamus.disney.repositories;

import com.acamus.disney.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Adrian E. Camus
 */
@Repository
public interface GenreRepo extends JpaRepository<Genre, Long>{
    
}
