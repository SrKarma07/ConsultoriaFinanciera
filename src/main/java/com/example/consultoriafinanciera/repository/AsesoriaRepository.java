package com.example.consultoriafinanciera.repository;

import com.example.consultoriafinanciera.entity.Asesoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsesoriaRepository extends JpaRepository<Asesoria, String> {
    // Puedes agregar métodos de consulta personalizados si los necesitas
}
