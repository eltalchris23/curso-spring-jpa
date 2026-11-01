package com.curso.store.producto.dto;

public record ProductoResponse(
        Long id,
        String nombre,
        Double precio
) {
}
