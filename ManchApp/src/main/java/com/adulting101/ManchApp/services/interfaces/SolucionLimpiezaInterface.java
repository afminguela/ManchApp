package com.adulting101.ManchApp.services.interfaces;


import com.adulting101.ManchApp.models.Material;
import com.adulting101.ManchApp.models.SolucionLimpieza;
import com.adulting101.ManchApp.models.TipoMancha;

import java.util.List;

public interface SolucionLimpiezaInterface {

    List<SolucionLimpieza> listaSolucionLimpieza(TipoMancha tipoMancha, Material material);

    SolucionLimpieza findById(Long id);

    SolucionLimpieza create(SolucionLimpieza solucionLimpieza);

    SolucionLimpieza delete(Long Id);

    SolucionLimpieza update(Long Id, SolucionLimpieza solucionLimpieza);
}
