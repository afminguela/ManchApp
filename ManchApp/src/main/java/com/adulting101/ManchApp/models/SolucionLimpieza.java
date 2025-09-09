package com.adulting101.ManchApp.models;

import com.adulting101.ManchApp.enums.Nivel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



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
        @Column(name="titulo")
        private String titulo;

        @NotNull(message = "Las instrucciones se han de consignar")
        @Column(name="instrucciones")
        private String instrucciones;

        @Min (value = 1, message =" el tiempo minimo es un minuto")
        private Integer tiempoMinutos;


        @Enumerated(EnumType.STRING)
        @Column(name ="dificultad")
        private Nivel dificultad;

        @Column(name ="efectividad")
        private Nivel efectividad;

        @ManyToOne(fetch = FetchType.LAZY)
        private Precauciones advertencias;

        private String consejos;

        private String categoria;

        @ManyToOne(fetch = FetchType.LAZY)
        private List<Material> material;

        @ManyToOne(fetch = FetchType.LAZY)
        private List<TipoMancha> mancha;

        @ManyToOne(fetch = FetchType.LAZY)
        private List<Utensilio> utensilios

        -Long id
        -String titulo
        -String instrucciones
        -Integer tiempoMinutos
        -Nivel dificultad
        -Integer efectividad
        -Precauciones advertencias
        -String consejos
        -boolean casero
        -List<Utensilio> utensilios
        -List<Ingrediente> ingredientes
        -List<TipoMancha> manchas
        -Categoria categoria
        -LocalDateTime fechaCreacion
}
