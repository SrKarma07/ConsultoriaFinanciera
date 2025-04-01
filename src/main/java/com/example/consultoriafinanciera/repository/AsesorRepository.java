package com.example.consultoriafinanciera.repository;

import com.example.consultoriafinanciera.entity.Asesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsesorRepository extends JpaRepository<Asesor, String> {
    // Puedes agregar métodos de consulta personalizados si los necesitas
}