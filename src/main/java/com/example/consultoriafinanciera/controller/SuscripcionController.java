package com.example.consultoriafinanciera.controller;

import com.example.consultoriafinanciera.entity.Suscripcion;
import com.example.consultoriafinanciera.service.SuscripcionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suscripciones")
public class SuscripcionController {

    private final SuscripcionService suscripcionService;

    public SuscripcionController(SuscripcionService suscripcionService) {
        this.suscripcionService = suscripcionService;
    }

    // Crear Suscripción
    @PostMapping
    public ResponseEntity<Suscripcion> create(@RequestBody Suscripcion suscripcion) {
        Suscripcion nueva = suscripcionService.createSuscripcion(suscripcion);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    // Obtener Suscripción por ID
    @GetMapping("/{id}")
    public ResponseEntity<Suscripcion> getById(@PathVariable("id") String id) {
        Suscripcion sus = suscripcionService.getSuscripcionById(id);
        return ResponseEntity.ok(sus);
    }

    // Listar todas las Suscripciones
    @GetMapping
    public ResponseEntity<List<Suscripcion>> getAll() {
        List<Suscripcion> lista = suscripcionService.getAllSuscripciones();
        return ResponseEntity.ok(lista);
    }

    // Actualizar Suscripción
    @PutMapping("/{id}")
    public ResponseEntity<Suscripcion> update(@PathVariable("id") String id,
                                              @RequestBody Suscripcion suscripcion) {
        Suscripcion actualizada = suscripcionService.updateSuscripcion(id, suscripcion);
        return ResponseEntity.ok(actualizada);
    }

    // Eliminar Suscripción
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        suscripcionService.deleteSuscripcion(id);
        return ResponseEntity.noContent().build();
    }

}
