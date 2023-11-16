package com.item.item.entity;

import lombok.Data;

@Data
public class Item {

    private Empleado empleado;
    private Integer cantidad;

    public Item(Empleado empleado, Integer cantidad) {
        this.empleado = empleado;
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return empleado.getHoras_lab() * cantidad.doubleValue();
    }

}
