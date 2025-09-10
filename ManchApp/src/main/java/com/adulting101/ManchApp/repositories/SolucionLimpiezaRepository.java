package com.adulting101.ManchApp.repositories;


import com.adulting101.ManchApp.models.Material;
import com.adulting101.ManchApp.models.Precauciones;
import com.adulting101.ManchApp.models.SolucionLimpieza;
import com.adulting101.ManchApp.models.TipoMancha;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolucionLimpiezaRepository extends JpaRepository<SolucionLimpieza,Long>{


    List<SolucionLimpieza> findAllByManchasAndMateriales(TipoMancha tipoMancha, Material material);
}
