package com.adecco.prueba.data.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the estado database table.
 * 
 */
@Entity
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado")
	private int idEstado;

	private String nombre;

	//bi-directional many-to-one association to Activo
	@OneToMany(mappedBy="estado", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Activo> activos;

	public Estado() {
	}

	public Estado(int idEstado) {
		this.idEstado = idEstado;
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Activo> getActivos() {
		return this.activos;
	}

	public void setActivos(List<Activo> activos) {
		this.activos = activos;
	}

	public Activo addActivo(Activo activo) {
		getActivos().add(activo);
		activo.setEstado(this);

		return activo;
	}

	public Activo removeActivo(Activo activo) {
		getActivos().remove(activo);
		activo.setEstado(null);

		return activo;
	}

	@Override
	public String toString() {
		return "Estado [idEstado=" + idEstado + ", nombre=" + nombre + "]";
	}

}