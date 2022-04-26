/*
 * Uso para capacitación
 * 2021 Año de la Prevención y Lucha contra el COVID-19.
 */
package com.acamus.disney.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Entity
@Table(name = "personajes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE personajes SET active = false WHERE id=?")
@Where(clause = "active = true")
public class Character implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String image;

    @Column(name = "nombre", nullable = false, length = 50)
    private String name;
    @Column(name = "edad", length = 6)
    private int age;
    @Column(name = "peso", length = 6)
    private double weight;
    @Column(name = "historia", length = 255)
    private String history;
    @Column(name = "activo")
    private boolean active = Boolean.TRUE;

    //ManyToMany: Muchos personajes pueden estar en muchas peliculas (Ejemplo sagas como Toy Story)
    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Movie> peliculas = new ArrayList<>();
}
