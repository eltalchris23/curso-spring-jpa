package com.curso.store.producto.service;

import com.curso.store.producto.exception.ProductoNoEncontradoException;
import com.curso.store.producto.model.clase2.ProductoRequest;
import com.curso.store.producto.model.clase2.ProductoResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private final List<ProductoResponse> productos = new ArrayList<>();
    private long siguienteId = 1;

    public List<ProductoResponse> obtenerTodos() {
        return productos;
    }

    public ProductoResponse obtenerPorId(Long id) {
        return productos.stream()
                .filter(producto -> producto.id().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ProductoNoEncontradoException(id));
    }

    public ProductoResponse crear(ProductoRequest request) {
        ProductoResponse producto = new ProductoResponse(
                siguienteId++, request.nombre(), request.precio());
        productos.add(producto);
        return producto;
    }

    public ProductoResponse actualizar(Long id,ProductoRequest request) {
        ProductoResponse existente = obtenerPorId(id);

        ProductoResponse actualizado = new ProductoResponse(
                existente.id(), request.nombre(), request.precio());

        productos.remove(existente);
        productos.add(actualizado);
        return actualizado;
    }

    public void eliminar(Long id) {
        ProductoResponse existente = obtenerPorId(id);
        productos.remove(existente);
    }

    public List<ProductoResponse> precioMenor(double limite) {
        return productos.stream()
                .filter(producto -> producto.precio() <= limite)
                .toList();
    }

}

