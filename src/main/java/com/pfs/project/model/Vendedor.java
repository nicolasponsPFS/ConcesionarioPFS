package com.pfs.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vendedor")
public class Vendedor {

	@Id
	@GeneratedValue
	private Integer id;
	private String usuario, pass, nombre, apellido;

	public Vendedor() {
		super();
	}

	public Vendedor(Integer id, String usuario, String pass, String nombre, String apellido) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.pass = pass;
		this.nombre = nombre;
		this.apellido = apellido;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String print() {
		return "Vendedor [id=" + id + ", usuario=" + usuario + ", pass=" + pass + ", nombre=" + nombre + ", apellido="
				+ apellido + "]";
	}

}
