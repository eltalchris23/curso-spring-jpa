package com.curso.store.producto.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<ApiError> manejarProductoNoEncontrado(ProductoNoEncontradoException exception, HttpServletRequest request) {
        ApiError error = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Recurso no encontrado",
                exception.getMessage(),
                request.getRequestURI(),
                Map.of()
        );

        log.info("404 {} {}: {}",
                request.getMethod(),
                request.getRequestURI(),
                exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> manejarValidaciones(MethodArgumentNotValidException exception, HttpServletRequest request) {
        Map<String, String> detalles = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error ->
                detalles.put(error.getField(), error.getDefaultMessage())
        );

        ApiError error = new ApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Datos inválidos",
                "La petición contiene errores",
                request.getRequestURI(),
                detalles
        );

        log.info("400 {} {}: errores de validación={}",
                request.getMethod(),
                request.getRequestURI(),
                detalles);

        return ResponseEntity.badRequest().body(error);
    }

}

