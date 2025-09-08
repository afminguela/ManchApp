package com.adulting101.ManchApp.models;

import com.adulting101.ManchApp.enums.Acabado;
import com.adulting101.ManchApp.enums.Nivel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "superficies")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Superficie extends Material {
    @NotBlank(message = "El tipo de superficie es obligatorio")
    @Column(name = "Tipo_de_superficie", nullable = false)
    public String tipoSuperficie;

    @NotBlank(message = "El tipo de fibra es obligatorio")
    @Column(name = "Resistente_al_Agua")
    public boolean resistenteAgua;

    @Column(name = "acabado")
    public Acabado acabado = Acabado.BRILLO;
    @Column(name = "porosidad", nullable = false)
    public Nivel porosidad = Nivel.MEDIUM;

}
