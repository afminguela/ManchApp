package com.adulting101.ManchApp.models;


import com.adulting101.ManchApp.enums.Nivel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
    @Inheritance(strategy = InheritanceType.JOINED)
    @Table(name = "materiales")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public abstract class Material {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "El nombre del material es obligatorio")
        @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
        @Column(nullable = false, unique = true)
        private String nombre;

        @Size(max = 500, message = "La descripción no puede exceder 500 caracteres")
        @Column(length = 500)
        private String descripcion;

        @Column(nullable = false)
        private boolean delicado = false;

        @Column(name = "porosidad",  )
        private Nivel porisidad

        @Column(name = "fecha_creacion", nullable = false)
        private LocalDateTime fechaCreacion;


        @OneToMany(mappedBy = "material", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<SolucionLimpieza> soluciones;

        @PrePersist
        protected void onCreate() {
            fechaCreacion = LocalDateTime.now();
        }
    }

