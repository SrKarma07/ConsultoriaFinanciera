package com.example.consultoriafinanciera.repository;

import com.example.consultoriafinanciera.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    // Puedes agregar métodos de consulta personalizados si los necesitas
}
