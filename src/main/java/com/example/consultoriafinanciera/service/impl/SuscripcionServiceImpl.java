package com.example.consultoriafinanciera.service.impl;

import com.example.consultoriafinanciera.entity.Suscripcion;
import com.example.consultoriafinanciera.repository.SuscripcionRepository;
import com.example.consultoriafinanciera.service.SuscripcionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuscripcionServiceImpl implements SuscripcionService {

    private final SuscripcionRepository suscripcionRepository;

    // Inyección de dependencias vía constructor
    public SuscripcionServiceImpl(SuscripcionRepository suscripcionRepository) {
        this.suscripcionRepository = suscripcionRepository;
    }

    @Override
    public Suscripcion createSuscripcion(Suscripcion suscripcion) {
        // Validar si ya existe una suscripción con ese numeroSuscripcion
        if (suscripcionRepository.existsById(suscripcion.getNumeroSuscripcion())) {
            throw new RuntimeException("La suscripción con ID " + suscripcion.getNumeroSuscripcion() + " ya existe.");
        }
        // Guardar
        return suscripcionRepository.save(suscripcion);
    }

    @Override
    public Suscripcion getSuscripcionById(String numeroSuscripcion) {
        return suscripcionRepository.findById(numeroSuscripcion)
                .orElseThrow(() -> new RuntimeException("No existe la suscripción con ID " + numeroSuscripcion));
    }

    @Override
    public List<Suscripcion> getAllSuscripciones() {
        return suscripcionRepository.findAll();
    }

    @Override
    public Suscripcion updateSuscripcion(String numeroSuscripcion, Suscripcion suscripcion) {
        // Verificar si existe la suscripción original
        Suscripcion existente = getSuscripcionById(numeroSuscripcion);

        // Actualizar los campos que deseas permitir
        existente.setTipoSuscripcion(suscripcion.getTipoSuscripcion());
        existente.setCantidadAsesorias(suscripcion.getCantidadAsesorias());
        existente.setSaldoAsesorias(suscripcion.getSaldoAsesorias());
        existente.setFechaCaducidad(suscripcion.getFechaCaducidad());
        existente.setEstado(suscripcion.getEstado());
        // Mantenemos el "numeroSuscripcion" anterior

        // Guardamos
        return suscripcionRepository.save(existente);
    }

    @Override
    public void deleteSuscripcion(String numeroSuscripcion) {
        if (!suscripcionRepository.existsById(numeroSuscripcion)) {
            throw new RuntimeException("No existe la suscripción con ID " + numeroSuscripcion);
        }
        suscripcionRepository.deleteById(numeroSuscripcion);
    }
}
