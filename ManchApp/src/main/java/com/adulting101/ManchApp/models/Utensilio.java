package com.adulting101.ManchApp.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Utensilios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utensilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nombre;

    @NotBlank
    public String descripcion;

    @ManyToMany(mappedBy = "utensilios")
    @JsonBackReference
    private List<SolucionLimpieza> solucionesLimpieza ;



}