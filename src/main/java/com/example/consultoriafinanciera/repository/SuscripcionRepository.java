package com.example.consultoriafinanciera.repository;

import com.example.consultoriafinanciera.entity.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuscripcionRepository extends JpaRepository<Suscripcion, String> {
    // Puedes agregar métodos de consulta personalizados si los necesitas
}