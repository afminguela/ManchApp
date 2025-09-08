package com.adulting101.ManchApp.models;

import com.adulting101.ManchApp.enums.Nivel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.security.PublicKey;

@Entity
@Data
@Table(name = "Manchas")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoMancha extends Sustancia {
    @NotBlank(message = "La categoria no puede estar en blanco")
    @Column(nullable = false, name = " categoria_mancha")
    public String CategoriaMancha;

    @NotBlank(message = "El origen no puede estar en blanco")
    @Column(nullable = false, name = "origen_mancha")
    public String origenMancha;


    @Column(nullable = false, name = "dificultad_limpieza")
    public Nivel dificultadLimpieza;

    @NotBlank(message = "El tipo no puede estar en blanco")
    @Column( name = "urgente")
    public boolean urgente;


    @Column( name = "se_fija_con_calor")
    public boolean seFijaConCalor;


    @Column(name = "Ph_Aprox")
    public double phAproximado;

    @Min(value = 0, message = "El valor minimo es 0")
    @Column(name = "tiempo_secado")
    public Double tiempoSecadoHoras;

}
