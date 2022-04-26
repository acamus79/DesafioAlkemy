package com.acamus.disney.entities;

import java.io.Serializable;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Entity
@Table(name = "generos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE generos SET active = false WHERE id=?")
@Where(clause = "active = true")
public class Genre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String image;

    private String name;

    private boolean active = Boolean.TRUE;

    @ManyToMany(mappedBy = "generos", cascade = CascadeType.ALL)
    private List<Movie> genreMovies = new ArrayList<>();
}