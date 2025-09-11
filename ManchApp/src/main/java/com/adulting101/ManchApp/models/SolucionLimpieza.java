package com.adulting101.ManchApp.models;

import com.adulting101.ManchApp.enums.Categoria;
import com.adulting101.ManchApp.enums.Nivel;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Soluciones_Limpieza")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolucionLimpieza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El titulo es obligatorio")
    @Column(name = "titulo")
    private String titulo;

    @NotBlank(message = "Las instrucciones se han de consignar")
    @Column(name = "instrucciones")
    private String instrucciones;

    @Min(value = 1, message = " el tiempo minimo es un minuto")
    @Column
    private Integer tiempoMinutos;


    @Enumerated(EnumType.STRING)
    @Column(name = "dificultad")
    private Nivel dificultad;

    @Column(name = "efectividad")
    private Nivel efectividad;


    @ManyToMany
    @JoinTable(
            name = "solucion_precauciones",
            joinColumns = @JoinColumn(name = "solucion_id"),
            inverseJoinColumns = @JoinColumn(name = "precaudiones_id")
    )
    private List<Precauciones> advertencias;

    private String consejos;

    private Categoria categoria;

    @ManyToMany
    @JoinTable(
            name = "solucion_material",
            joinColumns = @JoinColumn(name = "solucion_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    private List<Material> materiales;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "solucion_mancha",
            joinColumns = @JoinColumn(name = "solucion_id"),
            inverseJoinColumns = @JoinColumn(name = "mancha_id")
    )
    private List<TipoMancha> manchas;

    @ManyToMany
    @JoinTable(
            name = "soluciones_limpieza_ingredientes",
            joinColumns = @JoinColumn(name = "ingredientes_id"),
            inverseJoinColumns = @JoinColumn(name = "solucion_limpieza_id")
    )
    private List<Ingrediente> ingredientes;

    @ManyToMany
    @JoinTable(
            name = "soluciones_limpieza_utensilios",
            joinColumns = @JoinColumn(name = "solucion_limpieza_id"),
            inverseJoinColumns = @JoinColumn(name = "utensilios_id")
    )
    @JsonManagedReference
    private List<Utensilio> utensilios;
}