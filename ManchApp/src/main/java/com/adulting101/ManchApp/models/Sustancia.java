package com.adulting101.ManchApp.models;

import com.adulting101.ManchApp.enums.Nivel;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "sustancias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Sustancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la sustancia es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    @Column(nullable = false)
    private String nombre;

    @Size(max = 500, message = "La descripción no puede exceder 500 caracteres")
    @Column(length = 500)
    private String descripcion;

    @NotBlank(message = "El tipo de sustancia es obligatorio")
    @Column(name = "tipo_sustancia", nullable = false)
    private String tipoSustancia; // orgánica, química, natural, sintética

    @Column(length = 50)
    private String color;

    @Column(nullable = false)
    private boolean toxico = false;

    @Column(nullable = false)
    private boolean natural = true;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Nivel peligrosidad = Nivel.LOW;

    @Min(value = 1, message = "El valor minimo es 1.0")
    @Max(value = 14, message = "El valor máximo es 14.0")
    @Column(name = "ph_sustancia")
    public Long phSustancia;



    @OneToMany(mappedBy = "sustancia", fetch = FetchType.LAZY)
    @Column(name = "precauciones")
    private List<Precauciones> precauciones;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
    }
}
