package com.adulting101.ManchApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "precauciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Precauciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La descripcion no puede estar vacía")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "sustancia_id")
    private Sustancia sustancia;


}
