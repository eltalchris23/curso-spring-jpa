package com.curso.store.producto.controller;

import com.curso.store.producto.dto.OfertaResponse;
import com.curso.store.producto.dto.ProductoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
public class ProductoControllerDemo {

    @GetMapping("/saludo")
    public String saludar() {
        return "API de productos funcionando";
    }

    @GetMapping("/destacado")
    public ProductoResponse destacado(){
        return new ProductoResponse(1L,"Mac Book Pro",49000D);
    }

    @GetMapping("/buscar")
    public ProductoResponse buscar(@RequestParam String nombre){
        return new ProductoResponse(1L,nombre,49000D);
    }

    @GetMapping("/oferta")
    public OfertaResponse oferta(@RequestParam String nombre, @RequestParam double precio){
        double descuento = precio * 0.10;
        double precioFinal = precio - descuento;

        return new OfertaResponse(nombre,precio,descuento,precioFinal);
    }
}

