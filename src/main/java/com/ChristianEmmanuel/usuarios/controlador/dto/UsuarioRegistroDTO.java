package com.ChristianEmmanuel.usuarios.controlador.dto;

import java.sql.Date;

public class UsuarioRegistroDTO {

	private Long id;
	private String imagen;
	private String nombre;
	private String apellido;
	private String email;
	private Date fecha;
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	


	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public UsuarioRegistroDTO(String imagen, String nombre, String apellido, String email, Date fecha, String password) {
		super();
		this.imagen = imagen;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fecha = fecha;
		this.password = password;
	}

	public UsuarioRegistroDTO() {

	}

}
