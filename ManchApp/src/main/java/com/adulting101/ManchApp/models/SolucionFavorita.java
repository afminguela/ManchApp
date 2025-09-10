package com.adulting101.ManchApp.models;

import com.adulting101.ManchApp.enums.Nivel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "soluciones_favoritas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SolucionFavorita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private SolucionLimpieza solucionLimpieza;

    @Column(length = 300,name = "notas")
    private String notas;

    @Column(length = 100,nullable = false,name = "fecha_guardado")
    private LocalDateTime fechaGuardado;

    @Column(length = 1, name = "probado")
    private boolean probado;

    @Min(value = 0)
    @Max(value = 5)
    @NotNull
    @Column(length = 5, name = "Valoracion")
    private Integer valoracion;
}