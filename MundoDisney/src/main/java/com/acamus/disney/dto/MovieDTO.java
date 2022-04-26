package com.acamus.disney.dto;


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
public class MovieDTO {
    private String id;
    private String image;
    private String title;
    private String creationDate;
    private Integer rating;
    private List<CharacterDTO> personajesDTO = new ArrayList<>();
    private List<GenreDTO> generosDTO = new ArrayList<>();
}
