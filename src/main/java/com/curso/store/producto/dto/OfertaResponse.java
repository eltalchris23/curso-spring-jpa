package com.curso.store.producto.dto;

public record OfertaResponse(
        String nombre,
        double precioOriginal,
        double descuento,
        double precioFinal
) {
}
