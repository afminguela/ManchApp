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


        Tela lino = new Tela();
        lino.setNombre("Lino");
        lino.setDescripcion("Tejido natural, fresco y resistente.");
        lino.setTipoFibra("natural");
        lino.setDelicado(false);
        lino.setLavableMaquina(true);
        lino.setPermeabilidad(true);
        lino.setTemperaturaMaxima(40);
        telaRepository.save(lino);

        Tela poliester = new Tela();
        poliester.setNombre("Poliéster");
        poliester.setDescripcion("Fibra sintética resistente y fácil de lavar.");
        poliester.setTipoFibra("sintética");
        poliester.setDelicado(false);
        poliester.setLavableMaquina(true);
        poliester.setPermeabilidad(false);
        poliester.setTemperaturaMaxima(60);
        telaRepository.save(poliester);

        Tela microfibra = new Tela();
        microfibra.setNombre("Microfibra");
        microfibra.setDescripcion("Tejido sintético muy absorbente y de secado rápido.");
        microfibra.setTipoFibra("sintética");
        microfibra.setDelicado(false);
        microfibra.setLavableMaquina(true);
        microfibra.setPermeabilidad(true);
        microfibra.setTemperaturaMaxima(60);
        telaRepository.save(microfibra);

        Tela lana = new Tela();
        lana.setNombre("Lana");
        lana.setDescripcion("Fibra natural, cálida y delicada.");
        lana.setTipoFibra("natural");
        lana.setDelicado(true);
        lana.setLavableMaquina(false);
        lana.setPermeabilidad(true);
        lana.setTemperaturaMaxima(30);
        telaRepository.save(lana);

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


        Superficie marmol = new Superficie();
        marmol.setNombre("Mármol");
        marmol.setTipoSuperficie("mármol");
        marmol.setPorosidad(Nivel.LOW);
        marmol.setAcabado(Acabado.BRILLO);
        marmol.setDelicado(true);
        marmol.setDescripcion("Superficie elegante y delicada, común en cocinas.");
        superficeRepository.save(marmol);

        Superficie plastico = new Superficie();
        plastico.setNombre("Plástico");
        plastico.setTipoSuperficie("plástico");
        plastico.setPorosidad(Nivel.LOW);
        plastico.setAcabado(Acabado.BRILLO);
        plastico.setDelicado(false);
        plastico.setDescripcion("Superficie común en objetos y envases.");
        superficeRepository.save(plastico);

        Superficie acero = new Superficie();
        acero.setNombre("Acero inoxidable");
        acero.setTipoSuperficie("acero");
        acero.setPorosidad(Nivel.LOW);
        acero.setAcabado(Acabado.BRILLO);
        acero.setDelicado(false);
        acero.setDescripcion("Superficie metálica resistente y brillante.");
        superficeRepository.save(acero);

        Superficie ceramica = new Superficie();
        ceramica.setNombre("Cerámica");
        ceramica.setTipoSuperficie("cerámica");
        ceramica.setPorosidad(Nivel.MEDIUM);
        ceramica.setAcabado(Acabado.BRILLO);
        ceramica.setDelicado(false);
        ceramica.setDescripcion("Superficie común en baños y cocinas.");
        superficeRepository.save(ceramica);

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


        TipoMancha cafe = new TipoMancha();
        cafe.setNombre("Café");
        cafe.setDescripcion("Mancha de café sobre telas y superficies.");
        cafe.setCategoriaMancha(Categoria.Liquido);
        cafe.setOrigenMancha("Bebidas");
        cafe.setTipoSustancia("natural");
        cafe.setDificultadLimpieza(Nivel.MEDIUM);
        cafe.setPeligrosidad(Nivel.NONE);
        tipoManchaRepository.save(cafe);

        TipoMancha sangre = new TipoMancha();
        sangre.setNombre("Sangre");
        sangre.setDescripcion("Mancha orgánica difícil de quitar.");
        sangre.setCategoriaMancha(Categoria.ORGANICA);
        sangre.setOrigenMancha("Cortes, heridas");
        sangre.setTipoSustancia("natural");
        sangre.setDificultadLimpieza(Nivel.HIGH);
        sangre.setPeligrosidad(Nivel.LOW);
        tipoManchaRepository.save(sangre);

        TipoMancha chocolate = new TipoMancha();
        chocolate.setNombre("Chocolate");
        chocolate.setDescripcion("Mancha de chocolate en ropa y muebles.");
        chocolate.setCategoriaMancha(Categoria.ALIMENTO);
        chocolate.setOrigenMancha("Comida");
        chocolate.setTipoSustancia("natural");
        chocolate.setDificultadLimpieza(Nivel.MEDIUM);
        chocolate.setPeligrosidad(Nivel.NONE);
        tipoManchaRepository.save(chocolate);

        TipoMancha moho = new TipoMancha();
        moho.setNombre("Moho");
        moho.setDescripcion("Mancha de hongos en superficies húmedas.");
        moho.setCategoriaMancha(Categoria.ORGANICA);
        moho.setOrigenMancha("Humedad");
        moho.setTipoSustancia("natural");
        moho.setDificultadLimpieza(Nivel.HIGH);
        moho.setPeligrosidad(Nivel.MEDIUM);
        tipoManchaRepository.save(moho);

        TipoMancha maquillaje = new TipoMancha();
        maquillaje.setNombre("Maquillaje");
        maquillaje.setDescripcion("Mancha de cosméticos en ropa y superficies.");
        maquillaje.setCategoriaMancha(Categoria.ALIMENTO);
        maquillaje.setOrigenMancha("Cosméticos");
        maquillaje.setTipoSustancia("quimica");
        maquillaje.setDificultadLimpieza(Nivel.MEDIUM);
        maquillaje.setPeligrosidad(Nivel.NONE);
        tipoManchaRepository.save(maquillaje);

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


        Ingrediente jabon = new Ingrediente();
        jabon.setNombre("Jabón neutro");
        jabon.setTipoSustancia("quimica");
        jabon.setDescripcion("Jabón suave para limpieza general.");
        jabon.setTipoIngrediente("limpieza");
        jabon.setPropiedades("Suave, no abrasivo");
        jabon.setDisponibleSupermercado(true);
        ingredienteRepository.save(jabon);

        Ingrediente amoniaco = new Ingrediente();
        amoniaco.setNombre("Amoníaco");
        amoniaco.setTipoSustancia("quimica");
        amoniaco.setDescripcion("Líquido fuerte para manchas difíciles.");
        amoniaco.setTipoIngrediente("limpieza");
        amoniaco.setPropiedades("Desinfectante, potente");
        amoniaco.setDisponibleSupermercado(true);
        ingredienteRepository.save(amoniaco);

        Ingrediente percarbonato = new Ingrediente();
        percarbonato.setNombre("Percarbonato de sodio");
        percarbonato.setTipoSustancia("quimica");
        percarbonato.setDescripcion("Blanqueador ecológico para ropa y superficies.");
        percarbonato.setTipoIngrediente("limpieza");
        percarbonato.setPropiedades("Blanqueador, desinfectante");
        percarbonato.setDisponibleSupermercado(true);
        ingredienteRepository.save(percarbonato);

        Ingrediente sal = new Ingrediente();
        sal.setNombre("Sal");
        sal.setTipoSustancia("natural");
        sal.setDescripcion("Cristales para ayudar a remover manchas y fijar colores.");
        sal.setTipoIngrediente("limpieza");
        sal.setPropiedades("Abrasivo suave");
        sal.setDisponibleSupermercado(true);
        ingredienteRepository.save(sal);

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


        Utensilio guantes = new Utensilio();
        guantes.setNombre("Guantes de goma");
        guantes.setDescripcion("Protegen las manos de productos químicos.");
        utensilioRepository.save(guantes);

        Utensilio cubeta = new Utensilio();
        cubeta.setNombre("Cubeta");
        cubeta.setDescripcion("Recipiente para mezclar soluciones.");
        utensilioRepository.save(cubeta);

        Utensilio espatula = new Utensilio();
        espatula.setNombre("Espátula de plástico");
        espatula.setDescripcion("Para raspar manchas secas sin dañar la superficie.");
        utensilioRepository.save(espatula);

        Utensilio papelCocina = new Utensilio();
        papelCocina.setNombre("Papel de cocina");
        papelCocina.setDescripcion("Absorbe líquidos y ayuda a secar manchas.");
        utensilioRepository.save(papelCocina);

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


        Precauciones precaucion4 = new Precauciones();
        precaucion4.setDescripcion("Ventilar bien la zona al usar amoníaco.");
        precaucionesRepository.save(precaucion4);

        Precauciones precaucion5 = new Precauciones();
        precaucion5.setDescripcion("No usar en superficies porosas.");
        precaucionesRepository.save(precaucion5);

        Precauciones precaucion6 = new Precauciones();
        precaucion6.setDescripcion("No usar sobre lana.");
        precaucionesRepository.save(precaucion6);

        Precauciones precaucion7 = new Precauciones();
        precaucion7.setDescripcion("Evitar mezclar con otros blanqueadores.");
        precaucionesRepository.save(precaucion7);

        // Soluciones de limpieza ------------------------------
        SolucionLimpieza solucion1 = new SolucionLimpieza();
        solucion1.setTitulo("Quitar vino tinto de algodón");
        solucion1.setInstrucciones("Espolvorear sal sobre la mancha fresca, dejar absorber unos minutos, retirar la sal, enjuagar con agua fría y lavar con detergente suave.");
        solucion1.setTiempoMinutos(15);
        solucion1.setDificultad(Nivel.LOW);
        solucion1.setEfectividad(Nivel.HIGH);
        solucion1.setAdvertencias(Arrays.asList(precaucion1));
        solucion1.setConsejos("No dejar secar la mancha antes de limpiar. Si la mancha persiste, aplicar agua oxigenada diluida.");
        solucion1.setCategoria(Categoria.ROPA);
        solucion1.setIngredientes(Arrays.asList(sal, detergente));
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


        SolucionLimpieza solucion4 = new SolucionLimpieza();
        solucion4.setTitulo("Quitar café de lino");
        solucion4.setInstrucciones("Aplicar agua fría y jabón neutro, frotar suavemente y enjuagar.");
        solucion4.setTiempoMinutos(8);
        solucion4.setDificultad(Nivel.LOW);
        solucion4.setEfectividad(Nivel.MEDIUM);
        solucion4.setAdvertencias(Arrays.asList(precaucion3));
        solucion4.setConsejos("Actuar rápido antes de que se seque.");
        solucion4.setCategoria(Categoria.ROPA);
        solucion4.setIngredientes(Arrays.asList(jabon));
        solucion4.setManchas(Arrays.asList(cafe));
        solucion4.setMateriales(Arrays.asList(lino, algodon, poliester));
        solucion4.setUtensilios(Arrays.asList(trapo));
        solucionLimpiezaRepository.save(solucion4);

        SolucionLimpieza solucion5 = new SolucionLimpieza();
        solucion5.setTitulo("Eliminar sangre de algodón");
        solucion5.setInstrucciones("Remojar en agua fría, aplicar detergente y frotar suavemente.");
        solucion5.setTiempoMinutos(12);
        solucion5.setDificultad(Nivel.MEDIUM);
        solucion5.setEfectividad(Nivel.HIGH);
        solucion5.setAdvertencias(Arrays.asList(precaucion2));
        solucion5.setConsejos("No usar agua caliente.");
        solucion5.setCategoria(Categoria.ROPA);
        solucion5.setIngredientes(Arrays.asList(detergente));
        solucion5.setManchas(Arrays.asList(sangre));
        solucion5.setMateriales(Arrays.asList(algodon, lino, poliester));
        solucion5.setUtensilios(Arrays.asList(trapo));
        solucionLimpiezaRepository.save(solucion5);

        SolucionLimpieza solucion6 = new SolucionLimpieza();
        solucion6.setTitulo("Quitar chocolate de poliéster");
        solucion6.setInstrucciones("Raspar el exceso, aplicar agua tibia y jabón neutro.");
        solucion6.setTiempoMinutos(10);
        solucion6.setDificultad(Nivel.LOW);
        solucion6.setEfectividad(Nivel.MEDIUM);
        solucion6.setAdvertencias(Arrays.asList(precaucion5));
        solucion6.setConsejos("No frotar fuerte para no dañar la tela.");
        solucion6.setCategoria(Categoria.ROPA);
        solucion6.setIngredientes(Arrays.asList(jabon));
        solucion6.setManchas(Arrays.asList(chocolate));
        solucion6.setMateriales(Arrays.asList(poliester, algodon, lino));
        solucion6.setUtensilios(Arrays.asList(trapo));
        solucionLimpiezaRepository.save(solucion6);

        SolucionLimpieza solucion7 = new SolucionLimpieza();
        solucion7.setTitulo("Limpiar vino tinto de mármol");
        solucion7.setInstrucciones("Aplicar bicarbonato y agua, dejar actuar y limpiar con esponja.");
        solucion7.setTiempoMinutos(15);
        solucion7.setDificultad(Nivel.MEDIUM);
        solucion7.setEfectividad(Nivel.MEDIUM);
        solucion7.setAdvertencias(Arrays.asList(precaucion4));
        solucion7.setConsejos("No usar ácidos en mármol.");
        solucion7.setCategoria(Categoria.HOGAR);
        solucion7.setIngredientes(Arrays.asList(bicarbonato));
        solucion7.setManchas(Arrays.asList(vino));
        solucion7.setMateriales(Arrays.asList(marmol, plastico, vidrio));
        solucion7.setUtensilios(Arrays.asList(esponja));
        solucionLimpiezaRepository.save(solucion7);

        SolucionLimpieza solucion8 = new SolucionLimpieza();
        solucion8.setTitulo("Quitar grasa de plástico");
        solucion8.setInstrucciones("Aplicar detergente y agua caliente, frotar con esponja.");
        solucion8.setTiempoMinutos(7);
        solucion8.setDificultad(Nivel.LOW);
        solucion8.setEfectividad(Nivel.HIGH);
        solucion8.setAdvertencias(Arrays.asList(precaucion1));
        solucion8.setConsejos("Enjuagar bien para eliminar residuos.");
        solucion8.setCategoria(Categoria.HOGAR);
        solucion8.setIngredientes(Arrays.asList(detergente));
        solucion8.setManchas(Arrays.asList(aceite));
        solucion8.setMateriales(Arrays.asList(plastico, marmol, mesa));
        solucion8.setUtensilios(Arrays.asList(esponja));
        solucionLimpiezaRepository.save(solucion8);

        SolucionLimpieza solucion9 = new SolucionLimpieza();
        solucion9.setTitulo("Limpiar tinta de poliéster");
        solucion9.setInstrucciones("Aplicar alcohol y frotar suavemente con trapo.");
        solucion9.setTiempoMinutos(9);
        solucion9.setDificultad(Nivel.MEDIUM);
        solucion9.setEfectividad(Nivel.MEDIUM);
        solucion9.setAdvertencias(Arrays.asList(precaucion2));
        solucion9.setConsejos("No usar cloro.");
        solucion9.setCategoria(Categoria.ROPA);
        solucion9.setIngredientes(Arrays.asList(alcohol));
        solucion9.setManchas(Arrays.asList(tinta));
        solucion9.setMateriales(Arrays.asList(poliester, algodon, seda));
        solucion9.setUtensilios(Arrays.asList(trapo));
        solucionLimpiezaRepository.save(solucion9);

        SolucionLimpieza solucion10 = new SolucionLimpieza();
        solucion10.setTitulo("Eliminar café de mármol");
        solucion10.setInstrucciones("Limpiar con agua y jabón neutro, secar con paño.");
        solucion10.setTiempoMinutos(6);
        solucion10.setDificultad(Nivel.LOW);
        solucion10.setEfectividad(Nivel.MEDIUM);
        solucion10.setAdvertencias(Arrays.asList(precaucion5));
        solucion10.setConsejos("No dejar que el café se seque.");
        solucion10.setCategoria(Categoria.HOGAR);
        solucion10.setIngredientes(Arrays.asList(jabon));
        solucion10.setManchas(Arrays.asList(cafe));
        solucion10.setMateriales(Arrays.asList(marmol, plastico, vidrio));
        solucion10.setUtensilios(Arrays.asList(trapo));
        solucionLimpiezaRepository.save(solucion10);

        SolucionLimpieza solucion11 = new SolucionLimpieza();
        solucion11.setTitulo("Quitar sangre de lino");
        solucion11.setInstrucciones("Remojar en agua fría, aplicar jabón neutro y frotar suavemente.");
        solucion11.setTiempoMinutos(14);
        solucion11.setDificultad(Nivel.MEDIUM);
        solucion11.setEfectividad(Nivel.HIGH);
        solucion11.setAdvertencias(Arrays.asList(precaucion2));
        solucion11.setConsejos("No usar agua caliente.");
        solucion11.setCategoria(Categoria.ROPA);
        solucion11.setIngredientes(Arrays.asList(jabon));
        solucion11.setManchas(Arrays.asList(sangre));
        solucion11.setMateriales(Arrays.asList(lino, algodon, poliester));
        solucion11.setUtensilios(Arrays.asList(trapo));
        solucionLimpiezaRepository.save(solucion11);

        SolucionLimpieza solucion12 = new SolucionLimpieza();
        solucion12.setTitulo("Limpiar chocolate de mármol");
        solucion12.setInstrucciones("Raspar el exceso, limpiar con agua y detergente.");
        solucion12.setTiempoMinutos(11);
        solucion12.setDificultad(Nivel.LOW);
        solucion12.setEfectividad(Nivel.MEDIUM);
        solucion12.setAdvertencias(Arrays.asList(precaucion5));
        solucion12.setConsejos("No usar productos abrasivos.");
        solucion12.setCategoria(Categoria.HOGAR);
        solucion12.setIngredientes(Arrays.asList(detergente));
        solucion12.setManchas(Arrays.asList(chocolate));
        solucion12.setMateriales(Arrays.asList(marmol, plastico, mesa));
        solucion12.setUtensilios(Arrays.asList(trapo));
        solucionLimpiezaRepository.save(solucion12);

        SolucionLimpieza solucion13 = new SolucionLimpieza();
        solucion13.setTitulo("Quitar aceite de lino");
        solucion13.setInstrucciones("Aplicar bicarbonato, dejar actuar y lavar con agua tibia.");
        solucion13.setTiempoMinutos(13);
        solucion13.setDificultad(Nivel.MEDIUM);
        solucion13.setEfectividad(Nivel.HIGH);
        solucion13.setAdvertencias(Arrays.asList(precaucion1));
        solucion13.setConsejos("No usar agua caliente.");
        solucion13.setCategoria(Categoria.ROPA);
        solucion13.setIngredientes(Arrays.asList(bicarbonato));
        solucion13.setManchas(Arrays.asList(aceite));
        solucion13.setMateriales(Arrays.asList(lino, algodon, poliester));
        solucion13.setUtensilios(Arrays.asList(trapo));
        solucionLimpiezaRepository.save(solucion13);

        // 10 nuevas soluciones de limpieza
        SolucionLimpieza solucion14 = new SolucionLimpieza();
        solucion14.setTitulo("Quitar moho de cerámica");
        solucion14.setInstrucciones("Aplicar percarbonato y frotar con esponja, enjuagar bien.");
        solucion14.setTiempoMinutos(20);
        solucion14.setDificultad(Nivel.HIGH);
        solucion14.setEfectividad(Nivel.HIGH);
        solucion14.setAdvertencias(Arrays.asList(precaucion7));
        solucion14.setConsejos("Usar guantes y ventilar la zona.");
        solucion14.setCategoria(Categoria.HOGAR);
        solucion14.setIngredientes(Arrays.asList(percarbonato));
        solucion14.setManchas(Arrays.asList(moho));
        solucion14.setMateriales(Arrays.asList(ceramica, plastico, marmol));
        solucion14.setUtensilios(Arrays.asList(esponja, guantes));
        solucionLimpiezaRepository.save(solucion14);

        SolucionLimpieza solucion15 = new SolucionLimpieza();
        solucion15.setTitulo("Eliminar maquillaje de microfibra");
        solucion15.setInstrucciones("Aplicar detergente y frotar suavemente, enjuagar con agua tibia.");
        solucion15.setTiempoMinutos(8);
        solucion15.setDificultad(Nivel.LOW);
        solucion15.setEfectividad(Nivel.MEDIUM);
        solucion15.setAdvertencias(Arrays.asList(precaucion6));
        solucion15.setConsejos("No usar cloro para evitar dañar la tela.");
        solucion15.setCategoria(Categoria.ROPA);
        solucion15.setIngredientes(Arrays.asList(detergente));
        solucion15.setManchas(Arrays.asList(maquillaje));
        solucion15.setMateriales(Arrays.asList(microfibra, poliester, algodon));
        solucion15.setUtensilios(Arrays.asList(trapo));
        solucionLimpiezaRepository.save(solucion15);

        SolucionLimpieza solucion16 = new SolucionLimpieza();
        solucion16.setTitulo("Quitar sangre de lana");
        solucion16.setInstrucciones("Aplicar agua fría y sal, dejar actuar y enjuagar suavemente.");
        solucion16.setTiempoMinutos(15);
        solucion16.setDificultad(Nivel.MEDIUM);
        solucion16.setEfectividad(Nivel.MEDIUM);
        solucion16.setAdvertencias(Arrays.asList(precaucion6));
        solucion16.setConsejos("No frotar fuerte para no dañar la lana.");
        solucion16.setCategoria(Categoria.ROPA);
        solucion16.setIngredientes(Arrays.asList(sal));
        solucion16.setManchas(Arrays.asList(sangre));
        solucion16.setMateriales(Arrays.asList(lana, algodon, lino));
        solucion16.setUtensilios(Arrays.asList(trapo));
        solucionLimpiezaRepository.save(solucion16);

        SolucionLimpieza solucion17 = new SolucionLimpieza();
        solucion17.setTitulo("Limpiar grasa de acero inoxidable");
        solucion17.setInstrucciones("Aplicar vinagre y frotar con papel de cocina.");
        solucion17.setTiempoMinutos(5);
        solucion17.setDificultad(Nivel.LOW);
        solucion17.setEfectividad(Nivel.HIGH);
        solucion17.setAdvertencias(Arrays.asList(precaucion1));
        solucion17.setConsejos("Secar bien para evitar marcas.");
        solucion17.setCategoria(Categoria.HOGAR);
        solucion17.setIngredientes(Arrays.asList(vinagre));
        solucion17.setManchas(Arrays.asList(aceite));
        solucion17.setMateriales(Arrays.asList(acero, plastico, ceramica));
        solucion17.setUtensilios(Arrays.asList(papelCocina));
        solucionLimpiezaRepository.save(solucion17);

        SolucionLimpieza solucion18 = new SolucionLimpieza();
        solucion18.setTitulo("Quitar chocolate de microfibra");
        solucion18.setInstrucciones("Raspar con espátula, aplicar detergente y lavar.");
        solucion18.setTiempoMinutos(10);
        solucion18.setDificultad(Nivel.LOW);
        solucion18.setEfectividad(Nivel.MEDIUM);
        solucion18.setAdvertencias(Arrays.asList(precaucion3));
        solucion18.setConsejos("No dejar secar la mancha.");
        solucion18.setCategoria(Categoria.ROPA);
        solucion18.setIngredientes(Arrays.asList(detergente));
        solucion18.setManchas(Arrays.asList(chocolate));
        solucion18.setMateriales(Arrays.asList(microfibra, poliester, algodon));
        solucion18.setUtensilios(Arrays.asList(espatula, trapo));
        solucionLimpiezaRepository.save(solucion18);

        SolucionLimpieza solucion19 = new SolucionLimpieza();
        solucion19.setTitulo("Eliminar moho de mármol");
        solucion19.setInstrucciones("Aplicar percarbonato y frotar con esponja, enjuagar bien.");
        solucion19.setTiempoMinutos(18);
        solucion19.setDificultad(Nivel.HIGH);
        solucion19.setEfectividad(Nivel.HIGH);
        solucion19.setAdvertencias(Arrays.asList(precaucion7));
        solucion19.setConsejos("No usar ácidos en mármol.");
        solucion19.setCategoria(Categoria.HOGAR);
        solucion19.setIngredientes(Arrays.asList(percarbonato));
        solucion19.setManchas(Arrays.asList(moho));
        solucion19.setMateriales(Arrays.asList(marmol, ceramica, plastico));
        solucion19.setUtensilios(Arrays.asList(esponja, guantes));
        solucionLimpiezaRepository.save(solucion19);

        SolucionLimpieza solucion20 = new SolucionLimpieza();
        solucion20.setTitulo("Quitar maquillaje de lana");
        solucion20.setInstrucciones("Aplicar detergente suave y enjuagar con agua fría.");
        solucion20.setTiempoMinutos(7);
        solucion20.setDificultad(Nivel.LOW);
        solucion20.setEfectividad(Nivel.MEDIUM);
        solucion20.setAdvertencias(Arrays.asList(precaucion6));
        solucion20.setConsejos("No frotar fuerte para no dañar la lana.");
        solucion20.setCategoria(Categoria.ROPA);
        solucion20.setIngredientes(Arrays.asList(detergente));
        solucion20.setManchas(Arrays.asList(maquillaje));
        solucion20.setMateriales(Arrays.asList(lana, algodon, seda));
        solucion20.setUtensilios(Arrays.asList(trapo));
        solucionLimpiezaRepository.save(solucion20);

        SolucionLimpieza solucion21 = new SolucionLimpieza();
        solucion21.setTitulo("Limpiar grasa de cerámica");
        solucion21.setInstrucciones("Aplicar vinagre y frotar con esponja.");
        solucion21.setTiempoMinutos(6);
        solucion21.setDificultad(Nivel.LOW);
        solucion21.setEfectividad(Nivel.HIGH);
        solucion21.setAdvertencias(Arrays.asList(precaucion1));
        solucion21.setConsejos("Enjuagar bien para eliminar residuos.");
        solucion21.setCategoria(Categoria.HOGAR);
        solucion21.setIngredientes(Arrays.asList(vinagre));
        solucion21.setManchas(Arrays.asList(aceite));
        solucion21.setMateriales(Arrays.asList(ceramica, acero, plastico));
        solucion21.setUtensilios(Arrays.asList(esponja));
        solucionLimpiezaRepository.save(solucion21);

        SolucionLimpieza solucion22 = new SolucionLimpieza();
        solucion22.setTitulo("Quitar moho de microfibra");
        solucion22.setInstrucciones("Aplicar percarbonato y dejar secar al sol.");
        solucion22.setTiempoMinutos(16);
        solucion22.setDificultad(Nivel.MEDIUM);
        solucion22.setEfectividad(Nivel.MEDIUM);
        solucion22.setAdvertencias(Arrays.asList(precaucion7));
        solucion22.setConsejos("Lavar después de eliminar el moho.");
        solucion22.setCategoria(Categoria.ROPA);
        solucion22.setIngredientes(Arrays.asList(percarbonato));
        solucion22.setManchas(Arrays.asList(moho));
        solucion22.setMateriales(Arrays.asList(microfibra, poliester, algodon));
        solucion22.setUtensilios(Arrays.asList(trapo));
        solucionLimpiezaRepository.save(solucion22);

        SolucionLimpieza solucion23 = new SolucionLimpieza();
        solucion23.setTitulo("Eliminar maquillaje de acero inoxidable");
        solucion23.setInstrucciones("Aplicar alcohol y frotar con papel de cocina.");
        solucion23.setTiempoMinutos(5);
        solucion23.setDificultad(Nivel.LOW);
        solucion23.setEfectividad(Nivel.MEDIUM);
        solucion23.setAdvertencias(Arrays.asList(precaucion1));
        solucion23.setConsejos("Secar bien para evitar marcas.");
        solucion23.setCategoria(Categoria.HOGAR);
        solucion23.setIngredientes(Arrays.asList(alcohol));
        solucion23.setManchas(Arrays.asList(maquillaje));
        solucion23.setMateriales(Arrays.asList(acero, ceramica, plastico));
        solucion23.setUtensilios(Arrays.asList(papelCocina));
        solucionLimpiezaRepository.save(solucion23);


        System.out.println("--------DATOS CARGADOS CORRECTAMENTE EN LA BBDD ----");
        }
}
