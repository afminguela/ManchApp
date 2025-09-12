package com.adulting101.ManchApp.services.impl;

import com.adulting101.ManchApp.DTO.Material.MaterialRequestDTO;
import com.adulting101.ManchApp.DTO.tipoMancha.TipoManchaRequestDTO;
import com.adulting101.ManchApp.models.Material;
import com.adulting101.ManchApp.models.SolucionLimpieza;
import com.adulting101.ManchApp.models.TipoMancha;
import com.adulting101.ManchApp.repositories.SolucionLimpiezaRepository;
import com.adulting101.ManchApp.services.interfaces.SolucionLimpiezaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolucionLimpiezaImpl implements SolucionLimpiezaInterface {

    @Autowired
    private SolucionLimpiezaRepository solucionLimpiezaRepository;

    @Override
    public List<SolucionLimpieza> listaSolucionLimpieza(TipoManchaRequestDTO tipoMancha, MaterialRequestDTO material) {
        String nombreMancha = tipoMancha.getNombre();
        String nombreMaterial = material.getNombre();

        return solucionLimpiezaRepository.findAllByManchasNombreAndMaterialesNombre(nombreMancha, nombreMaterial);
    }

    @Override
    public SolucionLimpieza findById(Long id) {
        return solucionLimpiezaRepository.findById(id).orElse(null);

    }

    @Override
    public SolucionLimpieza create(SolucionLimpieza solucionLimpieza) {
        return solucionLimpiezaRepository.save(solucionLimpieza);
    }


    @Override
    public SolucionLimpieza delete(Long id) {
        SolucionLimpieza solucionDelete = solucionLimpiezaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Solución de limpieza no encontrada con el ID: " + id));

        solucionLimpiezaRepository.delete(solucionDelete);
        return solucionDelete;
    }


    @Override
    public SolucionLimpieza update(Long id, SolucionLimpieza solucionLimpieza) {
        SolucionLimpieza solucionUpdated = solucionLimpiezaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Solución de limpieza no encontrada con el ID: " + id));

        solucionUpdated.setManchas(solucionLimpieza.getManchas());
        solucionUpdated.setAdvertencias(solucionLimpieza.getAdvertencias());
        solucionUpdated.setMateriales(solucionLimpieza.getMateriales());
        solucionUpdated.setConsejos(solucionLimpieza.getConsejos());
        solucionUpdated.setCategoria(solucionLimpieza.getCategoria());
        solucionUpdated.setDificultad(solucionLimpieza.getDificultad());
        solucionUpdated.setEfectividad(solucionLimpieza.getEfectividad());
        solucionUpdated.setInstrucciones(solucionLimpieza.getInstrucciones());
        solucionUpdated.setTiempoMinutos(solucionLimpieza.getTiempoMinutos());
        solucionUpdated.setUtensilios(solucionLimpieza.getUtensilios());
        solucionUpdated.setTitulo(solucionLimpieza.getTitulo());
        solucionLimpiezaRepository.save(solucionUpdated);
        return solucionUpdated;
    }


}
