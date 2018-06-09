package com.adecco.prueba.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona")
	private int idPersona;

	private String mail;

	private String nombre;

	private String telefono;

	//bi-directional many-to-many association to Activo
	@ManyToMany
	@JoinTable(
		name="activo_by_persona"
		, joinColumns={
			@JoinColumn(name="persona_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="activo_id")
			}
		)
	private List<Activo> activos;

	public Persona() {
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Activo> getActivos() {
		return this.activos;
	}

	public void setActivos(List<Activo> activos) {
		this.activos = activos;
	}

}