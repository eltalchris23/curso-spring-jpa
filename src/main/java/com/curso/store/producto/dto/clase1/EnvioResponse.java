package com.curso.store.producto.dto.clase1;

public record EnvioResponse(
        double subtotal,
        double costoEnvio,
        double total
) {
}
