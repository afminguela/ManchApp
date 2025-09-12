package com.adulting101.ManchApp.controllers;

import com.adulting101.ManchApp.DTO.tipoMancha.TipoManchaRequestDTO;
import com.adulting101.ManchApp.models.SolucionLimpieza;
import com.adulting101.ManchApp.services.impl.SolucionLimpiezaImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

@WebMvcTest(SolucionLimpiezaController.class)
class SolucionLimpiezaControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SolucionLimpiezaImpl service;

    @Test
    public void getSolucionLimpiezaById_retorna200() throws Exception {


        Mockito.when(service.getSolucionLimpiezaById(1L)).thenReturn(inmueble);

        mockMvc.perform(get("/api/inmuebles/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Piso en Málaga"));
    }


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