package com.adulting101.ManchApp.controllers;

import com.adulting101.ManchApp.DTO.Material.MaterialRequestDTO;
import com.adulting101.ManchApp.DTO.tipoMancha.TipoManchaRequestDTO;
import com.adulting101.ManchApp.models.Material;
import com.adulting101.ManchApp.models.SolucionLimpieza;
import com.adulting101.ManchApp.models.TipoMancha;
import com.adulting101.ManchApp.services.impl.SolucionLimpiezaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/soluciones")
public class SolucionLimpiezaController {

    @Autowired
    private SolucionLimpiezaImpl service;

    @GetMapping
    public List<SolucionLimpieza> getSolucionLimpieza(
            @RequestParam(required = false) String nombreMancha,
            @RequestParam(required = false) String nombreMaterial) {
        TipoManchaRequestDTO tipoMancha = nombreMancha != null ? new TipoManchaRequestDTO(nombreMancha) : null;
        MaterialRequestDTO material = nombreMaterial != null ? new MaterialRequestDTO(nombreMaterial) : null;
        return service.listaSolucionLimpieza(tipoMancha, material);
    }
    @GetMapping("/{id}")
    public SolucionLimpieza getSolucionLimpiezaPorId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public SolucionLimpieza create(@RequestBody SolucionLimpieza solucionLimpieza) {
        return service.create(solucionLimpieza);
    }

    @DeleteMapping("/{id}")
    public SolucionLimpieza delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PatchMapping("/{id}")
    public SolucionLimpieza update(@PathVariable Long Id, @RequestBody SolucionLimpieza solucionLimpieza ) {
        return service.update(Id, solucionLimpieza);
    }

}
