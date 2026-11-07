package com.curso.store.producto.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ApiError(
        LocalDateTime fecha,
        int estado,
        String error,
        String mensaje,
        String ruta,
        Map<String, String> detalles
) { }

