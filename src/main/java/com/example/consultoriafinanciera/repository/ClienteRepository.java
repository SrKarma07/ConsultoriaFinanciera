package com.example.consultoriafinanciera.repository;

import com.example.consultoriafinanciera.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    // Buscar un cliente usando clienteId como clave de negocio
    Optional<Cliente> findByClienteId(String clienteId);

    // Verificar existencia por clienteId
    boolean existsByClienteId(String clienteId);

    // Eliminar por clienteId

    void deleteByClienteId(String clienteId);
}
