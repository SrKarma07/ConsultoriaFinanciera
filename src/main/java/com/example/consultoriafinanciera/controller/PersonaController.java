package com.example.consultoriafinanciera.controller;

import com.example.consultoriafinanciera.entity.Persona;
import com.example.consultoriafinanciera.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService personaService;

    // Inyección de dependencias vía constructor
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    // Crear persona (POST)
    @PostMapping
    public ResponseEntity<Persona> create(@RequestBody Persona persona) {
        Persona nuevaPersona = personaService.createPersona(persona);
        return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
    }

    // Obtener una persona por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") String id) {
        Persona persona = personaService.getPersonaById(id);
        return ResponseEntity.ok(persona);
    }

    // Listar todas las personas (GET)
    @GetMapping
    public ResponseEntity<List<Persona>> getAll() {
        List<Persona> personas = personaService.getAllPersonas();
        return ResponseEntity.ok(personas);
    }

    // Actualizar persona (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Persona> update(@PathVariable("id") String id,
                                          @RequestBody Persona persona) {
        persona.setIdentificacion(id); // En caso de que el ID vaya en la URL
        Persona updated = personaService.updatePersona(persona);
        return ResponseEntity.ok(updated);
    }

    // Eliminar persona (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        personaService.deletePersona(id);
        return ResponseEntity.noContent().build();
    }
}
