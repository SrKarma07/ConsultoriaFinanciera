package com.example.consultoriafinanciera.service.impl;

import com.example.consultoriafinanciera.entity.Asesoria;
import com.example.consultoriafinanciera.repository.AsesoriaRepository;
import com.example.consultoriafinanciera.service.AsesoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsesoriaServiceImpl implements AsesoriaService {

    private final AsesoriaRepository asesoriaRepository;

    // Inyectamos el repositorio
    public AsesoriaServiceImpl(AsesoriaRepository asesoriaRepository) {
        this.asesoriaRepository = asesoriaRepository;
    }

    @Override
    public Asesoria createAsesoria(Asesoria asesoria) {
        // Aquí podrías incluir lógica adicional, por ejemplo:
        // - Validar fechaCaducidad de la suscripción
        // - Actualizar saldo de asesorías, etc.
        return asesoriaRepository.save(asesoria);
    }

    @Override
    public Asesoria getAsesoriaById(Long id) {
        Optional<Asesoria> optional = asesoriaRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("No existe la asesoría con ID: " + id);
        }
        return optional.get();
    }

    @Override
    public List<Asesoria> getAllAsesorias() {
        return asesoriaRepository.findAll();
    }

    @Override
    public Asesoria updateAsesoria(Long id, Asesoria asesoria) {
        // Verificamos existencia
        Asesoria existente = getAsesoriaById(id);

        // Actualizamos los campos
        existente.setFecha(asesoria.getFecha());
        existente.setTipoAsesoria(asesoria.getTipoAsesoria());
        existente.setEstado(asesoria.getEstado());
        existente.setCantidad(asesoria.getCantidad());
        existente.setSaldoAsesorias(asesoria.getSaldoAsesorias());

        // Si está relacionado con Suscripcion, también podemos actualizarlo
        existente.setSuscripcion(asesoria.getSuscripcion());

        return asesoriaRepository.save(existente);
    }

    @Override
    public void deleteAsesoria(Long id) {
        if (!asesoriaRepository.existsById(id)) {
            throw new RuntimeException("No existe la asesoría con ID: " + id);
        }
        asesoriaRepository.deleteById(id);
    }
}
