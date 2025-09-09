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
    public class SolucionLimpieza {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String titulo;
        private String instrucciones;
        private Integer tiempoMinutos;


        @Enumerated(EnumType.STRING)
        private Nivel dificultad;

        private Integer efectividad;

        @ManyToOne(fetch = FetchType.LAZY)
        private Precauciones advertencias;

        private String consejos;
        private boolean casero;


        private String categoria;

        @ManyToOne(fetch = FetchType.LAZY)
        private Material material;

        @ManyToOne(fetch = FetchType.LAZY)
        private TipoMancha mancha;
}
