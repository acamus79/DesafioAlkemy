package com.acamus.disney.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieBasicDTO {
    private String image;
    private String title;
    private LocalDate creationDate;
}
