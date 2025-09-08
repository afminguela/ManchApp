package com.adulting101.ManchApp.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
    @Table(name = "telas")
    @Data
    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    public class Tela extends Material {

        @NotBlank(message = "El tipo de fibra es obligatorio")
        @Column(name = "tipo_fibra", nullable = false)
        private String tipoFibra;

        @Column(name = "lavable_maquina", nullable = false)
        private boolean lavableMaquina = true;

        @Column(name = "cuidados_especiales")
        private String cuidadosEspeciales;

        @Min(value = 20, message = "La temperatura mínima debe ser 20°C")
        @Max(value = 95, message = "La temperatura máxima debe ser 95°C")
        @Column(name = "temperatura_maxima")
        private Integer temperaturaMaxima = 40;

        @Column(name = "secado_aire")
        private boolean secadoAlAire = false;

        @Column(name="permeabilidad")
        private boolean permeabilidad = false;

        public Tela(String nombre, String descripcion, boolean delicado,
                    String tipoFibra, boolean lavableMaquina, Integer temperaturaMaxima) {
            super();
            this.setNombre(nombre);
            this.setDescripcion(descripcion);
            this.setDelicado(delicado);
            this.tipoFibra = tipoFibra;
            this.lavableMaquina = lavableMaquina;
            this.temperaturaMaxima = temperaturaMaxima;
        }
    }

