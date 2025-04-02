package com.example.consultoriafinanciera.service;

import com.example.consultoriafinanciera.entity.Suscripcion;

import java.util.List;

public interface SuscripcionService {

    Suscripcion createSuscripcion(Suscripcion suscripcion);

    Suscripcion getSuscripcionById(String numeroSuscripcion);

    List<Suscripcion> getAllSuscripciones();

    Suscripcion updateSuscripcion(String numeroSuscripcion, Suscripcion suscripcion);

    void deleteSuscripcion(String numeroSuscripcion);
}
