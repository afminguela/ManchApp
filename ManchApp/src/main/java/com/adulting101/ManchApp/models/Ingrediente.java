package com.adulting101.ManchApp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "ingredientes")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ingrediente extends Sustancia {


    @Column(name = "tipoIngrediente")
    public String tipoIngrediente;

    @Column(name = "propiedades")
    public String propiedades;
    @Column(name = "disponible_supermercado")
    public boolean disponibleSupermercado;
}
