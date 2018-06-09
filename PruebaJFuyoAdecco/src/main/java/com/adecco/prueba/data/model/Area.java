package com.adecco.prueba.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_area")
	private int idArea;

	private String nombre;

	//bi-directional many-to-many association to Activo
	@ManyToMany
	@JoinTable(
		name="activo_by_area"
		, joinColumns={
			@JoinColumn(name="area_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="activo_id")
			}
		)
	private List<Activo> activos;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="ciudad_id")
	private Ciudad ciudad;

	public Area() {
	}

	public int getIdArea() {
		return this.idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
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

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Area [idArea=" + idArea + ", nombre=" + nombre + ", ciudad=" + ciudad + "]";
	}

}