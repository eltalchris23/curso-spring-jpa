package com.curso.store.producto.dto.clase1;

public record OfertaResponse(
        String nombre,
        double precioOriginal,
        double descuento,
        double precioFinal
) {
}
