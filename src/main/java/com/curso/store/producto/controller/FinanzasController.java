package com.curso.store.producto.controller;

import com.curso.store.producto.dto.EnvioResponse;
import com.curso.store.producto.dto.FinanzasResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FinanzasController {

    @GetMapping("/conversion")
    public FinanzasResponse conversion(@RequestParam double pesos, @RequestParam double tipoCambio){
        double dolares = pesos / tipoCambio;

        return new FinanzasResponse(pesos,tipoCambio,dolares);
    }

    @GetMapping("/envio")
    public EnvioResponse envio(@RequestParam double subtotal){
        double costoEnvio = 0;
        if (subtotal < 1000){
            costoEnvio = 150;
        }
        double total = subtotal + costoEnvio;

        return new EnvioResponse(subtotal,costoEnvio,total);
    }
}
