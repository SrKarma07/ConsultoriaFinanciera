package com.example.consultoriafinanciera.service.impl;

import com.example.consultoriafinanciera.entity.Asesor;
import com.example.consultoriafinanciera.repository.AsesorRepository;
import com.example.consultoriafinanciera.service.AsesorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsesorServiceImpl implements AsesorService {

    private final AsesorRepository asesorRepository;

    public AsesorServiceImpl(AsesorRepository asesorRepository) {
        this.asesorRepository = asesorRepository;
    }

    @Override
    public Asesor createAsesor(Asesor asesor) {
        // Verifica si existe ya un asesor con el mismo asesorId
        if (asesorRepository.existsByAsesorId(asesor.getAsesorId())) {
            throw new RuntimeException("Ya existe un asesor con el ID: " + asesor.getAsesorId());
        }
        // Guarda
        return asesorRepository.save(asesor);
    }

    @Override
    public Asesor getAsesorById(String asesorId) {
        return asesorRepository.findByAsesorId(asesorId)
                .orElseThrow(() -> new RuntimeException("No existe el asesor con ID: " + asesorId));
    }

    @Override
    public List<Asesor> getAllAsesores() {
        return asesorRepository.findAll();
    }

    @Override
    public Asesor updateAsesor(String asesorId, Asesor asesor) {
        // Verificamos si existe
        Asesor existente = getAsesorById(asesorId);

        // Actualizamos campos (los que desees permitir)
        existente.setIdentificacion(asesor.getIdentificacion());
        existente.setNombre(asesor.getNombre());
        existente.setGenero(asesor.getGenero());
        existente.setEdad(asesor.getEdad());
        existente.setDireccion(asesor.getDireccion());
        existente.setTelefono(asesor.getTelefono());

        existente.setAsesorId(asesorId); // Mantenemos el anterior (o lo sobreescribimos si quieres)
        existente.setEmail(asesor.getEmail());
        existente.setEstado(asesor.getEstado());

        return asesorRepository.save(existente);
    }

    @Override
    public void deleteAsesor(String asesorId) {
        if (!asesorRepository.existsByAsesorId(asesorId)) {
            throw new RuntimeException("No existe el asesor con ID: " + asesorId);
        }
        asesorRepository.deleteByAsesorId(asesorId);
    }
}
