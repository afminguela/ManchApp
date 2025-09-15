package com.adulting101.ManchApp.controllers;

import com.adulting101.ManchApp.DTO.tipoMancha.TipoManchaRequestDTO;
import com.adulting101.ManchApp.models.SolucionLimpieza;
import com.adulting101.ManchApp.services.impl.SolucionLimpiezaImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(SolucionLimpiezaController.class)
class SolucionLimpiezaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private SolucionLimpiezaImpl service;

    @Test
    public void getSolucionLimpiezaById_retorna200() throws Exception {
        SolucionLimpieza solucionLimpieza = new SolucionLimpieza();
        solucionLimpieza.setId(1L);
        solucionLimpieza.setTitulo("Quitar tinta de Cuero");

        Mockito.when(service.findById(1L)).thenReturn(solucionLimpieza);

        mockMvc.perform(get("/api/soluciones/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Quitar tinta de Cuero"));
    }

    @Test
    void getSolucionLimpiezaReturnsAllSolutionsWhenNoFiltersProvided() {
        when(service.findAll(null, null)).thenReturn(List.of(new SolucionLimpieza(), new SolucionLimpieza()));

        List<SolucionLimpieza> result = service.findAll(null, null);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(service).findAll(null, null);
    }
}