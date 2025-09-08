package com.adulting101.ManchApp.enums;

public enum Nivel {

    EXTREME("Riesgo MUY ALTO"),
    HIGH("Riesgo Alto, no usar"),
    MEDIUM("Riesgo medio, usar con precaudión"),
    LOW("Riesgo bajo, facil de implementar"),
    NONE("sin riesgo ni dificultad");

private String descripcion;
    Nivel(String descripcion) {
      this.descripcion = descripcion;
    }
}
