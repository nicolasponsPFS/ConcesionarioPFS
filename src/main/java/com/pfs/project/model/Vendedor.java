package com.pfs.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Entity
@Table(name="Vendedor")
public class Vendedor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue
	private Integer id;
	private String usuario, pass, nombre, apellidos;
	
	public Vendedor() {
		super();
	}

	public Vendedor(Integer id, String usuario, String pass, String nombre, String apellidos) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.pass = pass;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", usuario=" + usuario + ", pass=" + pass + ", nombre=" + nombre + ", apellidos="
				+ apellidos + "]";
	}
	
}
