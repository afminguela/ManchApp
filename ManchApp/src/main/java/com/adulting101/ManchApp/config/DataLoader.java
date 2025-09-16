package com.adulting101.ManchApp.config;

import com.adulting101.ManchApp.enums.*;
import com.adulting101.ManchApp.models.*;
import com.adulting101.ManchApp.repositories.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@Component

public class DataLoader implements CommandLineRunner {


    @Autowired
    private TipoManchaRepository tipoManchaRepository;
    @Autowired
    private SolucionLimpiezaRepository solucionLimpiezaRepository;
    @Autowired
    private IngredienteRepository ingredienteRepository;
    @Autowired
    private UtensilioRepository utensilioRepository;
    @Autowired
    private PrecaucionesRepository precaucionesRepository;
    @Autowired
    private SuperficeRepository superficeRepository;
    @Autowired
    private TelaRepository telaRepository;



    @Autowired
    private SolucionFavoritaRepository solucionFavoritaRepository;


    @Override
    public void run(String... args) {
        // Materiales
        Tela algodon = new Tela();
        algodon.setNombre("Algodón");
            algodon.setDescripcion("Tejido suave y absorbente, usado en ropa y textiles.");
            algodon.setTipoFibra("natural");
            algodon.setDelicado(false);
            algodon.setLavableMaquina(true);
            algodon.setPermeabilidad(true);
            algodon.setPorosidad(Nivel.MEDIUM);

        telaRepository.save(algodon);


        Tela cuero =  new Tela();
            cuero.setNombre("Cuero");
            cuero.setDescripcion("Material resistente y elegante, usado en muebles y ropa.");
            cuero.setTipoFibra("natural");
            cuero.setDelicado(true);
            cuero.setLavableMaquina(false);
            cuero.setPermeabilidad(true);
            cuero.setPorosidad(Nivel.LOW);

        telaRepository.save(cuero);

        Tela seda =  new Tela();
            seda.setNombre("Seda");
            seda.setTipoFibra("natural");
            seda.setDescripcion("Tela fina y delicada, usada en prendas elegantes.");
            seda.setLavableMaquina(false);
            seda.setPermeabilidad(true);
            seda.setDelicado(true);

        telaRepository.save(seda);

        // Superficies
        Superficie mesa = new Superficie();
        mesa.setNombre("Mesa");
        mesa.setTipoSuperficie("madera");
        mesa.setPorosidad(Nivel.MEDIUM);
        mesa.setAcabado(Acabado.SATINADO);
        mesa.setDelicado(false);
        mesa.setDescripcion("Superficie dura, común en muebles y pisos.");
        superficeRepository.save(mesa);

        Superficie vidrio = new Superficie();
        vidrio.setTipoSuperficie("Vidrio");
        vidrio.setNombre("Vidrio");
        vidrio.setDescripcion("Superficie lisa y transparente, usada en ventanas y mesas.");
        vidrio.setPorosidad(Nivel.MEDIUM);
        vidrio.setAcabado(Acabado.SATINADO);
        vidrio.setDelicado(true);
        superficeRepository.save(vidrio);

        // Tipos de mancha
        TipoMancha vino = new TipoMancha();
        vino.setNombre("Vino tinto");
        vino.setDescripcion("Mancha de vino tinto sobre superficies y telas.");
        vino.setCategoriaMancha(Categoria.Liquido);
        vino.setOrigenMancha("Bebidas alcohólicas");
        vino.setDificultadLimpieza(Nivel.MEDIUM);

        vino.setPeligrosidad(Nivel.NONE);
        vino.setTipoSustancia("natural");
        tipoManchaRepository.save(vino);

        TipoMancha aceite = new TipoMancha();
        aceite.setNombre("Aceite");
        aceite.setDescripcion("Mancha de grasa o aceite. de testura viscosa");
        aceite.setCategoriaMancha(Categoria.GRASA);
        aceite.setTipoSustancia("natural");
        aceite.setOrigenMancha("Cocina o talleres");
        aceite.setDificultadLimpieza(Nivel.LOW);
        aceite.setPeligrosidad(Nivel.NONE);
        tipoManchaRepository.save(aceite);

        TipoMancha tinta = new TipoMancha();
        tinta.setNombre("Tinta");
        tinta.setTipoSustancia("quimica");
        tinta.setDescripcion("Mancha de boli o pluma");
        tinta.setCategoriaMancha(Categoria.Liquido);
        tinta.setOrigenMancha("Material de oficina");
        tinta.setDificultadLimpieza(Nivel.HIGH);
        tinta.setPeligrosidad(Nivel.NONE);
        tipoManchaRepository.save(tinta);



        // Ingredientes ----------------------
        Ingrediente bicarbonato = new Ingrediente();
        bicarbonato.setNombre("Bicarbonato de sodio");
        bicarbonato.setTipoSustancia("quimica");
        bicarbonato.setDescripcion("Polvo blanco para limpieza y desodorización.");
        ingredienteRepository.save(bicarbonato);

        Ingrediente vinagre = new Ingrediente();
        vinagre.setNombre("Vinagre blanco");
        vinagre.setTipoSustancia("natural");
        vinagre.setDescripcion("Líquido ácido para limpieza y desinfección.");
        ingredienteRepository.save(vinagre);

        Ingrediente detergente = new Ingrediente();
        detergente.setNombre("Detergente suave");
        detergente.setTipoSustancia("quimica");
        detergente.setDescripcion("Detergente líquido para ropa y superficies delicadas.");
        ingredienteRepository.save(detergente);

        Ingrediente cloro = new Ingrediente();
        cloro.setNombre("Cloro");
        cloro.setDescripcion("Desinfectante fuerte, no mezclar con vinagre.");
        cloro.setTipoSustancia("quimica");
        ingredienteRepository.save(cloro);

        Ingrediente alcohol = new Ingrediente();
        alcohol.setNombre("Alcohol");
        alcohol.setDescripcion("Alcohol para limpieza.");
        alcohol.setTipoSustancia("natural");
        ingredienteRepository.save(alcohol);


        // Utensilios-------------------------------------
        Utensilio esponja = new Utensilio();
        esponja.setNombre("Esponja");
        esponja.setDescripcion("Utensilio para frotar superficies.");
        utensilioRepository.save(esponja);

        Utensilio cepillo = new Utensilio();
        cepillo.setNombre("Cepillo de dientes");
        cepillo.setDescripcion("Cepillo pequeño para detalles y manchas difíciles.");
        utensilioRepository.save(cepillo);

        Utensilio trapo = new Utensilio();
        trapo.setNombre("Paño de microfibra");
        trapo.setDescripcion("Paño suave para limpiar y secar superficies.");
        utensilioRepository.save(trapo);

        // Precauciones . ---------------------------
        Precauciones precaucion1 = new Precauciones();
        precaucion1.setDescripcion("No mezclar con cloro. ");
        precaucionesRepository.save(precaucion1);

        Precauciones precaucion2 = new Precauciones();
        precaucion2.setDescripcion("Probar en zona poco visible antes de aplicar. ");
        precaucionesRepository.save(precaucion2);

        Precauciones precaucion3 = new Precauciones();
        precaucion3.setDescripcion("No frotar");
        precaucionesRepository.save(precaucion3);
                // Soluciones de limpieza ------------------------------
        SolucionLimpieza solucion1 = new SolucionLimpieza();
        solucion1.setTitulo("Quitar vino tinto de algodón");
        solucion1.setInstrucciones("Mezclar bicarbonato y vinagre, aplicar sobre la mancha, dejar actuar 10 minutos y enjuagar. ");
        solucion1.setTiempoMinutos(15);
        solucion1.setDificultad(Nivel.LOW);
        solucion1.setEfectividad(Nivel.LOW);
        solucion1.setAdvertencias(Arrays.asList(precaucion1));
        solucion1.setConsejos("No dejar secar la mancha antes de limpiar. ");
        solucion1.setCategoria(Categoria.ROPA);
        solucion1.setIngredientes(Arrays.asList(bicarbonato, vinagre));
        solucion1.setManchas(Arrays.asList(vino));
        solucion1.setMateriales(Arrays.asList(algodon));
        solucion1.setUtensilios(Arrays.asList(esponja, trapo));
        solucionLimpiezaRepository.save(solucion1);

        SolucionLimpieza solucion2 = new SolucionLimpieza();
        solucion2.setTitulo("Eliminar grasa de cuero");
        solucion2.setInstrucciones("Usar cepillo y detergente suave, frotar suavemente y limpiar con paño húmedo.");
        solucion2.setTiempoMinutos(20);
        solucion2.setDificultad(Nivel.MEDIUM);
        solucion2.setEfectividad(Nivel.HIGH);
        solucion2.setAdvertencias(Arrays.asList(precaucion2));
        solucion2.setConsejos("No mojar demasiado el cuero. ");
        solucion2.setTiempoMinutos(10);
        solucion2.setCategoria(Categoria.HOGAR);
        solucion2.setIngredientes(Arrays.asList(detergente));
        solucion2.setManchas(Arrays.asList(aceite));
        solucion2.setMateriales(Arrays.asList(cuero, algodon, seda));
        solucion2.setUtensilios(Arrays.asList(cepillo, trapo));
        solucionLimpiezaRepository.save(solucion2);

        SolucionLimpieza solucion3 = new SolucionLimpieza();
        solucion3.setTitulo("Eliminar tinta de madera");
        solucion3.setInstrucciones("Aplicar alcohol isopropílico con paño, frotar suavemente y secar. ");
        solucion3.setTiempoMinutos(10);
        solucion3.setDificultad(Nivel.MEDIUM);
        solucion3.setEfectividad(Nivel.HIGH);
        solucion3.setAdvertencias(Arrays.asList(precaucion2, precaucion1));
        solucion3.setConsejos("No usar demasiada cantidad para evitar daños.");
        solucion2.setTiempoMinutos(10);
        solucion3.setCategoria(Categoria.HOGAR);
        solucion3.setIngredientes(Arrays.asList(vinagre, alcohol));
        solucion3.setManchas(Arrays.asList(tinta));
        solucion3.setMateriales(Arrays.asList(algodon));
        solucion3.setUtensilios(Arrays.asList(trapo));
        solucionLimpiezaRepository.save(solucion3);


        System.out.println("--------DATOS CARGADOS CORRECTAMENTE EN LA BBDD ----");
        }
}

