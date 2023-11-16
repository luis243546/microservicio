package com.item.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.item.item.service.ItemServiceImpl;

@RestController
public class PagoController {

    @Autowired
    ItemServiceImpl itemServiceImpl;

    @GetMapping("/calcularPago/{dni}")
    public Double calcularPago(@PathVariable String dni, @RequestBody Integer cantidad) {
        return itemServiceImpl.calcularTotalPagar(dni, cantidad);
    }

    

}
