package com.adulting101.ManchApp.repositories;


import com.adulting101.ManchApp.models.SolucionLimpieza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolucionLimpiezaRepository extends JpaRepository<SolucionLimpieza,Long> {


    List<SolucionLimpieza> findAllByManchasNombreAndMaterialesNombre(String manchasNombre, String materialesNombre);

}
