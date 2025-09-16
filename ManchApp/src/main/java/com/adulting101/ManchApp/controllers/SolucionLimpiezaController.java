package com.adulting101.ManchApp.controllers;

import com.adulting101.ManchApp.DTO.Material.MaterialRequestDTO;
import com.adulting101.ManchApp.DTO.tipoMancha.TipoManchaRequestDTO;
import com.adulting101.ManchApp.models.Material;
import com.adulting101.ManchApp.models.SolucionLimpieza;
import com.adulting101.ManchApp.models.TipoMancha;
import com.adulting101.ManchApp.services.impl.SolucionLimpiezaImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@RequestMapping("/api/soluciones")
public class SolucionLimpiezaController {

    @Autowired
    private SolucionLimpiezaImpl service;

    @Operation(summary = "Lista soluciones de limpieza", description = "Devuelve todas las soluciones de limpieza. Puedes filtrar por tipo de mancha y material.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Listado de soluciones de limpieza",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = SolucionLimpieza.class)))
    })
    @GetMapping
    public List<SolucionLimpieza> getSolucionLimpieza(
            @Parameter(description = "Nombre del tipo de mancha para filtrar", example = "vino")
            @RequestParam(required = false) String nombreMancha,
            @Parameter(description = "Nombre del material para filtrar", example = "algodón")
            @RequestParam(required = false) String nombreMaterial) {
        TipoManchaRequestDTO tipoMancha = nombreMancha != null ? new TipoManchaRequestDTO(nombreMancha) : null;
        MaterialRequestDTO material = nombreMaterial != null ? new MaterialRequestDTO(nombreMaterial) : null;
        return service.listaSolucionLimpieza(tipoMancha, material);
    }

    @Operation(summary = "Obtiene una solución de limpieza por ID", description = "Devuelve la solución de limpieza correspondiente al ID proporcionado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Solución encontrada",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = SolucionLimpieza.class))),
        @ApiResponse(responseCode = "404", description = "No se encontró la solución de limpieza",
                content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/{id}")
    public SolucionLimpieza getSolucionLimpiezaPorId(
            @Parameter(description = "ID de la solución de limpieza", example = "1")
            @PathVariable Long id) {
        SolucionLimpieza solucion = service.findById(id);
        if (solucion == null) {
            throw new ResourceNotFoundException("Solución de limpieza no encontrada con id: " + id);
        }
        return solucion;
    }

    @Operation(summary = "Crea una nueva solución de limpieza", description = "Crea y guarda una nueva solución de limpieza en la base de datos.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Solución creada",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = SolucionLimpieza.class)))
    })
    @PostMapping
    public SolucionLimpieza create(
            @Parameter(description = "Objeto solución de limpieza a crear", required = true)
            @RequestBody SolucionLimpieza solucionLimpieza) {
        return service.create(solucionLimpieza);
    }

    @Operation(summary = "Elimina una solución de limpieza", description = "Elimina la solución de limpieza correspondiente al ID proporcionado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Solución eliminada",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = SolucionLimpieza.class))),
        @ApiResponse(responseCode = "404", description = "No se encontró la solución de limpieza",
                content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("/{id}")
    public SolucionLimpieza delete(
            @Parameter(description = "ID de la solución de limpieza a eliminar", example = "1")
            @PathVariable Long id) {
        SolucionLimpieza deleted = service.delete(id);
        if (deleted == null) {
            throw new ResourceNotFoundException("No se puede eliminar. Solución de limpieza no encontrada con id: " + id);
        }
        return deleted;
    }

    @Operation(summary = "Actualiza parcialmente una solución de limpieza", description = "Actualiza los datos de una solución de limpieza existente.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Solución actualizada",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = SolucionLimpieza.class))),
        @ApiResponse(responseCode = "404", description = "No se encontró la solución de limpieza",
                content = @Content(mediaType = "application/json"))
    })
    @PatchMapping("/{id}")
    public SolucionLimpieza update(
            @Parameter(description = "ID de la solución de limpieza a actualizar", example = "1")
            @PathVariable("id") Long id,
            @Parameter(description = "Objeto solución de limpieza con los cambios", required = true)
            @RequestBody SolucionLimpieza solucionLimpieza ) {
        SolucionLimpieza updated = service.update(id, solucionLimpieza);
        if (updated == null) {
            throw new ResourceNotFoundException("No se puede actualizar. Solución de limpieza no encontrada con id: " + id);
        }
        return updated;
    }

}
