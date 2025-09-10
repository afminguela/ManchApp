package com.adulting101.ManchApp.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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



}