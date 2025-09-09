package com.adulting101.ManchApp.models;

import com.adulting101.ManchApp.enums.Acabado;
import com.adulting101.ManchApp.enums.Nivel;
import jakarta.persistence.*;
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


    @Column(name = "Resistente_al_Agua", nullable = false)
    public boolean resistenteAgua = false;

    @Column(name = "acabado")
    @Enumerated(EnumType.STRING)
    public Acabado acabado = Acabado.BRILLO;

    @Column(name = "porosidad", nullable = false)
    @Enumerated(EnumType.STRING)
    public Nivel porosidad = Nivel.MEDIUM;

}
