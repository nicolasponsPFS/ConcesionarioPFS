package com.pfs.project.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Coche")
public class Coche implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	private String marca, modelo, matricula;
	private Estado estado;
	private Motor motor = Motor.Gasolina;
	private Double precio;
	private Date anyo;
	private Integer potencia;
	private Boolean disponible;
	private Vendedor vendedor;
	
	public Coche() {
		super();
	}
	
	public Coche(Integer id, String marca, String modelo, String matricula, Estado estado, Motor motor, Double precio,
			Date anyo, Integer potencia, Boolean disponible, Vendedor vendedor) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.estado = estado;
		this.motor = motor;
		this.precio = precio;
		this.anyo = anyo;
		this.potencia = potencia;
		this.disponible = disponible;
		this.vendedor = vendedor;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	
	public Double getPrecio() {
		return precio;
	}
	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Date getAnyo() {
		return anyo;
	}
	
	public void setAnyo(Date anyo) {
		this.anyo = anyo;
	}
	
	public Integer getPotencia() {
		return potencia;
	}
	
	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}
	
	public Boolean getDisponible() {
		return disponible;
	}
	
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	
	@ManyToOne(targetEntity = Vendedor.class)
	@JoinColumn(name = "vendedor_id")
	public Vendedor getIdVendedor() {
		return vendedor;
	}
	
	public void setIdVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
}
