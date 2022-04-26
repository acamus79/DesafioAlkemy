package com.acamus.disney.dto;

import com.acamus.disney.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDTO {
    private Long id;
    private String image;
    private String name;
    private double weight;
    private String history;
    private int age;
    private List<MovieDTO> peliculas = new ArrayList<>();
}
