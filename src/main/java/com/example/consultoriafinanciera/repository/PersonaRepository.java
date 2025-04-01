package com.example.consultoriafinanciera.repository;

import com.example.consultoriafinanciera.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, String> {
    // Puedes agregar métodos de consulta personalizados si los necesitas
}
