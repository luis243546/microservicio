package com.item.item.service;

import java.time.Period;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.item.item.entity.Empleado;
import com.item.item.entity.Item;

@Service
public class ItemServiceImpl {
    @Autowired
	RestTemplate clienteRest;
	
	public List<Item> findAll() {
        List<Empleado> empleados = Arrays.asList(clienteRest.getForObject("http://localhost:8001/empleado/listar", Empleado[].class));
        return empleados.stream().map(empleado -> new Item(empleado, 1)).collect(Collectors.toList());
    }

	public Item findById(String dni, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("dni", dni);
        Empleado empleado = clienteRest.getForObject("http://localhost:8002/empleado/listar/{dni}", Empleado.class, pathVariables);
        return new Item(empleado,cantidad);
    }


    public Double calcularTotalPagar(String dni, Integer cantidad) {
        Item item = findById(dni, cantidad);
        return item.getTotal();
    }


}
