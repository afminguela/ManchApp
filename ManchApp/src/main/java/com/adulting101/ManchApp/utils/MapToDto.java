package com.adulting101.ManchApp.utils;

import com.adulting101.ManchApp.DTO.Material.MaterialRequestDTO;
import com.adulting101.ManchApp.DTO.tipoMancha.TipoManchaRequestDTO;
import com.adulting101.ManchApp.models.Material;
import com.adulting101.ManchApp.models.TipoMancha;

public interface MapToDto {


    static TipoManchaRequestDTO mapManchaToDTO(TipoMancha mancha){
        TipoManchaRequestDTO dto = new TipoManchaRequestDTO();
        dto.setNombre(mancha.getNombre());

        return dto;
    }


    static MaterialRequestDTO mapMateriaToDTO(Material material){
        MaterialRequestDTO dto = new MaterialRequestDTO();
        dto.setNombre(material.getNombre());

        return dto;
    }









}
