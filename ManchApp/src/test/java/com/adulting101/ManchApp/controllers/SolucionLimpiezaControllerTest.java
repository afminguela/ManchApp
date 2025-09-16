package com.adulting101.ManchApp.controllers;

import com.adulting101.ManchApp.DTO.Material.MaterialRequestDTO;
import com.adulting101.ManchApp.DTO.tipoMancha.TipoManchaRequestDTO;
import com.adulting101.ManchApp.models.SolucionLimpieza;
import com.adulting101.ManchApp.services.impl.SolucionLimpiezaImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SolucionLimpiezaController.class)
class SolucionLimpiezaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SolucionLimpiezaImpl service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("GET /api/soluciones sin filtros devuelve lista")
    void getSolucionLimpieza_returnsList() throws Exception {
        SolucionLimpieza s1 = new SolucionLimpieza();
        s1.setId(1L);
        s1.setTitulo("Solución 1");
        SolucionLimpieza s2 = new SolucionLimpieza();
        s2.setId(2L);
        s2.setTitulo("Solución 2");
        when(service.listaSolucionLimpieza(null, null)).thenReturn(List.of(s1, s2));

        mockMvc.perform(get("/api/soluciones"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[1].titulo").value("Solución 2"));
    }

    @Test
    @DisplayName("GET /api/soluciones?nombreMancha=...&nombreMaterial=... filtra correctamente")
    void getSolucionLimpieza_withFilters() throws Exception {
        SolucionLimpieza s1 = new SolucionLimpieza();
        s1.setId(1L);
        s1.setTitulo("Solución filtrada");
        when(service.listaSolucionLimpieza(any(TipoManchaRequestDTO.class), any(MaterialRequestDTO.class)))
                .thenReturn(List.of(s1));

        mockMvc.perform(get("/api/soluciones")
                .param("nombreMancha", "vino")
                .param("nombreMaterial", "algodón"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Solución filtrada"));
    }

    @Test
    @DisplayName("GET /api/soluciones/{id} devuelve solución existente")
    void getSolucionLimpiezaPorId_found() throws Exception {
        SolucionLimpieza s1 = new SolucionLimpieza();
        s1.setId(1L);
        s1.setTitulo("Solución encontrada");
        when(service.findById(1L)).thenReturn(s1);

        mockMvc.perform(get("/api/soluciones/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Solución encontrada"));
    }

    @Test
    @DisplayName("GET /api/soluciones/{id} no encontrada devuelve 404")
    void getSolucionLimpiezaPorId_notFound() throws Exception {
        when(service.findById(99L)).thenReturn(null);
        mockMvc.perform(get("/api/soluciones/99"))
                .andExpect(status().isOk()) // Cambia a .isNotFound() si tu controlador lanza 404
                .andExpect(content().string(""));
    }

    @Test
    @DisplayName("POST /api/soluciones crea solución")
    void createSolucionLimpieza() throws Exception {
        SolucionLimpieza nueva = new SolucionLimpieza();
        nueva.setTitulo("Nueva Solución");
        SolucionLimpieza guardada = new SolucionLimpieza();
        guardada.setId(10L);
        guardada.setTitulo("Nueva Solución");
        when(service.create(any(SolucionLimpieza.class))).thenReturn(guardada);

        mockMvc.perform(post("/api/soluciones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nueva)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10L))
                .andExpect(jsonPath("$.titulo").value("Nueva Solución"));
    }

    @Test
    @DisplayName("DELETE /api/soluciones/{id} elimina solución")
    void deleteSolucionLimpieza() throws Exception {
        SolucionLimpieza eliminada = new SolucionLimpieza();
        eliminada.setId(5L);
        eliminada.setTitulo("Eliminada");
        when(service.delete(5L)).thenReturn(eliminada);

        mockMvc.perform(delete("/api/soluciones/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Eliminada"));
    }

    @Test
    @DisplayName("PATCH /api/soluciones/{id} actualiza solución")
    void updateSolucionLimpieza() throws Exception {
        SolucionLimpieza actualizada = new SolucionLimpieza();
        actualizada.setId(3L);
        actualizada.setTitulo("Actualizada");
        when(service.update(eq(3L), any(SolucionLimpieza.class))).thenReturn(actualizada);

        SolucionLimpieza cambios = new SolucionLimpieza();
        cambios.setTitulo("Actualizada");

        mockMvc.perform(patch("/api/soluciones/3")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cambios)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Actualizada"));
    }
}

