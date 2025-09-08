package com.adulting101.ManchApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Ingredientes")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ingrediente extends Sustancia{
    public String tipoIngrediente;

    public String propiedades;

    public double phIngrediente;

    public boolean disponibleSupermercado;
}
