package com.curso.store.producto.model;

public record ProductoResponse(
        Long id,
        String nombre,
        double precio
) { }

