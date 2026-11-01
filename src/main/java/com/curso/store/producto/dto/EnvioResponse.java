package com.curso.store.producto.dto;

public record EnvioResponse(
        double subtotal,
        double costoEnvio,
        double total
) {
}
