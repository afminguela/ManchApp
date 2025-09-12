package com.adulting101.ManchApp.controllers;

import com.adulting101.ManchApp.DTO.tipoMancha.TipoManchaRequestDTO;
import com.adulting101.ManchApp.models.SolucionLimpieza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

class SolucionLimpiezaControllerTest {

    @Test
    void getSolucionLimpiezaReturnsAllSolutionsWhenNoFiltersProvided() {
        // Mock behavior
        when(service.listaSolucionLimpieza(null, null)).thenReturn(List.of(new SolucionLimpieza(), new SolucionLimpieza()));

        // Call the method
        List<SolucionLimpieza> result = controller.getSolucionLimpieza(null, null);

        // Assertions
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(service).listaSolucionLimpieza(null, null);
    }

    @Test
    void getSolucionLimpiezaFiltersByNombreMancha() {
        // Mock behavior
        TipoManchaRequestDTO tipoMancha = new TipoManchaRequestDTO("Vino");
        when(service.listaSolucionLimpieza(tipoMancha, null)).thenReturn(List.of(new SolucionLimpieza()));

        // Call the method
        List<SolucionLimpieza> result = controller.getSolucionLimpieza("Vino", null);

        // Assertions
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(service).listaSolucionLimpieza(tipoMancha, null);
    }

    @Test
    void getSolucionLimpieza() {


    }

    @Test
    void getSolucionLimpiezaPorId() {
    }

    @Test
    void create() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}