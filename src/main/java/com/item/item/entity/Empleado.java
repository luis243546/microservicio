package com.item.item.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Empleado {
    private String dni;
	private String nombre;
	private String ap_pat;
	private String ap_mat;
	private Integer horas_lab;
	private Date fecha_nac;

}
