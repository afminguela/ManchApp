package com.adulting101.ManchApp.enums;

public enum Acabado {
    MATE("El acabado es mate, no brilla"),
    BRILLO("El acabado es brillante"),
    SATINADO("El acabado es satinado")

    ;
    private String descripcion;
    Acabado(String descripcion) {
        this.descripcion = descripcion;
    }
}
