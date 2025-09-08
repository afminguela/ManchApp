# ManchApp
“Convertir la eliminación de manchas en un proceso sencillo, rápido y hasta divertido, ofreciendo soluciones prácticas, ecológicas y personalizadas, hechas por madres para madres y adultos jóvenes en su camino de Adulting 101.”

´´´´mermaid

classDiagram
    %% PRIMERA HERENCIA - Sustancia como clase padre
    class Sustancia {
        <<abstract>>
        -Long id
        -String nombre
        -String descripcion
        -String tipoSustancia
        -String color
        -boolean toxico
        -boolean natural
        -PeligrosidadNivel peligrosidad
        -LocalDateTime fechaCreacion
        +getId() Long
        +getNombre() String
        +getDescripcion() String
        +isToxico() boolean
        +isNatural() boolean
    }

    class TipoMancha {
        -String categoriaMancha
        -String origen
        -DificultadLimpieza dificultadLimpieza
        -boolean urgente
        -boolean seFijaConCalor
        -Double phAproximado
        -Integer tiempoSecadoHoras
        +getCategoriaMancha() String
        +getOrigen() String
        +getDificultadLimpieza() DificultadLimpieza
        +isUrgente() boolean
        +isSeFijaConCalor() boolean
    }

    class Ingrediente {
        -String tipoIngrediente
        -BigDecimal phValor
        -BigDecimal concentracionMaxima
        -Integer tiempoContactoMaxMinutos
        -BigDecimal precioAproximado
        -boolean disponibleSupermercado
        -boolean requiereVentilacion
        -boolean compatibleConAgua
        -EstadoFisico estadoFisico
        -String temperaturaAlmacenamiento
        +getTipoIngrediente() String
        +getPhValor() BigDecimal
        +getEstadoFisico() EstadoFisico
        +isDisponibleSupermercado() boolean
        +isRequiereVentilacion() boolean
    }

    %% SEGUNDA HERENCIA - Material como clase padre
    class Material {
        <<abstract>>
        -Long id
        -String nombre
        -String descripcion
        -boolean delicado
        -LocalDateTime fechaCreacion
        +getId() Long
        +getNombre() String
        +getDescripcion() String
        +isDelicado() boolean
    }

    class Tela {
        -String tipoFibra
        -boolean lavableMaquina
        -String cuidadosEspeciales
        -int temperaturaMaxima
        -boolean secadoAire
        +getTipoFibra() String
        +isLavableMaquina() boolean
        +getCuidadosEspeciales() String
        +getTemperaturaMaxima() int
        +isSecadoAire() boolean
    }

    class Superficie {
        -String tipoSuperficie
        -boolean resistenteAgua
        -String acabado
        -boolean poroso
        +getTipoSuperficie() String
        +isResistenteAgua() boolean
        +getAcabado() String
        +isPoroso() boolean
    }

    %% Entidad principal de soluciones
    class SolucionLimpieza {
        -Long id
        -String titulo
        -String instrucciones
        -Integer tiempoMinutos
        -DificultadAplicacion dificultadAplicacion
        -Integer efectividad
        -String advertencias
        -String consejos
        -boolean casero
        -boolean requiereVentilacion
        -boolean seguroParaNiños
        -LocalDateTime fechaCreacion
        +getId() Long
        +getTitulo() String
        +getInstrucciones() String
        +getEfectividad() Integer
        +isCasero() boolean
        +isRequiereVentilacion() boolean
    }

    %% Entidad de usuarios (para autenticación)
    class Usuario {
        -Long id
        -String username
        -String email
        -String password
        -String nombre
        -String apellidos
        -boolean activo
        -LocalDateTime fechaRegistro
        +getId() Long
        +getUsername() String
        +getEmail() String
        +isActivo() boolean
    }

    %% Entidad de favoritos del usuario
    class SolucionFavorita {
        -Long id
        -String notas
        -LocalDateTime fechaGuardado
        -boolean probado
        -Integer valoracion
        +getId() Long
        +getNotas() String
        +isProbado() boolean
        +getValoracion() Integer
    }

    %% Entidad de categorías para mejor organización
    class Categoria {
        -Long id
        -String nombre
        -String descripcion
        -String icono
        -String color
        +getId() Long
        +getNombre() String
        +getIcono() String
    }

    %% RELACIONES DE HERENCIA
    Sustancia <|-- TipoMancha
    Sustancia <|-- Ingrediente
    Material <|-- Tela
    Material <|-- Superficie

    %% RELACIONES ENTRE ENTIDADES
    TipoMancha ||--o{ SolucionLimpieza : "tiene soluciones"
    Material ||--o{ SolucionLimpieza : "se aplica en"
    SolucionLimpieza }o--o{ Ingrediente : "contiene"
    Ingrediente }o--o{ Ingrediente : "incompatible con"
    Usuario ||--o{ SolucionFavorita : "guarda"
    SolucionLimpieza ||--o{ SolucionFavorita : "es guardada"
    Categoria ||--o{ TipoMancha : "categoriza"

    %% ANOTACIONES
    note for Sustancia "Estrategia JOINED - Clase padre para TipoMancha e Ingrediente"
    note for Material "Estrategia JOINED - Clase padre para Tela y Superficie"
    note for SolucionLimpieza "Ahora relacionada con múltiples ingredientes"
    note for Ingrediente "Nueva entidad: vinagre, bicarbonato, detergente, etc."

    ´´´´
