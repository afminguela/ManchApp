package com.adulting101.ManchApp.models;

import com.adulting101.ManchApp.enums.Nivel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
    @Table(name="Soluciones_Limpieza")
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

    @ManyToOne(fetch = FetchType.LAZY)
    private Precauciones advertencias;

    private String consejos;

    private String categoria;

    @ManyToMany(fetch = FetchType.LAZY)
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

    @OneToMany(fetch = FetchType.LAZY)
    private List<Utensilio> utensilios;

}