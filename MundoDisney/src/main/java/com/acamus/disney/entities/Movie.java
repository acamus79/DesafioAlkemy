package com.acamus.disney.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Entity
@Table(name = "peliculas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE peliculas SET active = false WHERE id=?")
@Where(clause = "active = true")
public class Movie implements Serializable {
    //utilizo uuid para las peliculas en el caso de querer usar el ID como un codigo para generar un QR
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(length = 36)
    private String id;

    private String image;
    @Column(name = "titulo", length = 6)
    private String title;

    @Column(name = "fecha_estreno")
    private LocalDate creationDate;

    @Column(name = "calificacion", length = 1)
    private Integer rating;

    //como para hacer un falso borrado en la BD, por defecto se crea en true(1) y con la anotacion SQLDelete lo cambiamos a false(0)
    private boolean active = Boolean.TRUE;

    //Relacion una película puede tener muchoS personajes, y un personaje puede ser de variaS peliculasS
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "pelicula_personajes",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    private List<Character> personajes = new ArrayList<>();

    //Relacion una película puede tener muchoS generoS, y un genero puede ser de variaS peliculasS
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "pelicula_generos",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> generos = new ArrayList<>();

    /**
     *
     * @param personaje
     */
    public void addCharacter(Character personaje) {
        this.personajes.add(personaje);
    }
    /**
     *
     * @param personaje
     */
    public void removeCharacter(Character personaje) {
        this.personajes.remove(personaje);
    }
    /**
     *
     * @param genero
     */
    public void addGenre(Genre genero) {
        this.generos.add(genero);
    }

    /**
     *
     * @param genero
     */
    public void removeGenre(Genre genero) {
        this.generos.remove(genero);
    }

}