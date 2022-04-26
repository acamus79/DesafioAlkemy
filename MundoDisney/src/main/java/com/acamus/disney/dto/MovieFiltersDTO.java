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
public class MovieFiltersDTO {

    private String title;
    private Set<Long> genre;
    private String order;

    public boolean isASC() {
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDESC() {
        return this.order.compareToIgnoreCase("DESC") == 0;
    }
}
