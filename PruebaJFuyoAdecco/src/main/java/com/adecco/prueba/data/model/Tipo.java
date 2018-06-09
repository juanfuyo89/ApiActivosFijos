package com.adecco.prueba.data.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the tipo database table.
 * 
 */
@Entity
@NamedQuery(name="Tipo.findAll", query="SELECT t FROM Tipo t")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo")
	private int idTipo;

	private String nombre;

	//bi-directional many-to-one association to Activo
	@OneToMany(mappedBy="tipo", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Activo> activos;

	public Tipo() {
	}

	public Tipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
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
		activo.setTipo(this);

		return activo;
	}

	public Activo removeActivo(Activo activo) {
		getActivos().remove(activo);
		activo.setTipo(null);

		return activo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tipo [idTipo=" + idTipo + ", nombre=" + nombre + "]";
	}

}