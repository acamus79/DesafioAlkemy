package com.acamus.disney.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Set;
import lombok.Data;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterFiltersDTO {
    private String name;
    private Integer age;
    private Set<String> movies;
}