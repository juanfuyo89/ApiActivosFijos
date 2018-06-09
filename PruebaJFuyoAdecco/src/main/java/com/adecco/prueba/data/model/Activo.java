package com.adecco.prueba.data.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the activo database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Activo.findAll", query="SELECT a FROM Activo a"),
    @NamedQuery(name="Activo.updateActivo", query = "UPDATE Activo a SET a.serial = ?, a.fechaBaja = ? WHERE a.idActivo = ?")
})
public class Activo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_activo")
	private int idActivo;

	private int alto;

	private int ancho;

	private String color;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_baja")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-M-yyyy")
	@JsonIgnore
	private Date fechaBaja;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_compra")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-M-yyyy")
	@JsonIgnore
	private Date fechaCompra;

	@Column(name="interno_inventario")
	private int internoInventario;

	private int largo;

	private String nombre;

	private int peso;

	private String serial;

	@Column(name="valor_compra")
	private double valorCompra;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="estado_id")
	private Estado estado;

	//bi-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name="tipo_id")
	private Tipo tipo;

	//bi-directional many-to-many association to Area
	@ManyToMany(mappedBy="activos", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Area> areas;

	//bi-directional many-to-many association to Persona
	@ManyToMany(mappedBy="activos", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Persona> personas;

	public Activo() {
	}

	public int getIdActivo() {
		return this.idActivo;
	}

	public void setIdActivo(int idActivo) {
		this.idActivo = idActivo;
	}

	public int getAlto() {
		return this.alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return this.ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Date getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public int getInternoInventario() {
		return this.internoInventario;
	}

	public void setInternoInventario(int internoInventario) {
		this.internoInventario = internoInventario;
	}

	public int getLargo() {
		return this.largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPeso() {
		return this.peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public double getValorCompra() {
		return this.valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Area> getAreas() {
		return this.areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	@Override
	public String toString() {
		return "Activo [idActivo=" + idActivo + ", alto=" + alto + ", ancho=" + ancho + ", color=" + color
				+ ", fechaBaja=" + fechaBaja + ", fechaCompra=" + fechaCompra + ", internoInventario="
				+ internoInventario + ", largo=" + largo + ", nombre=" + nombre + ", peso=" + peso + ", serial="
				+ serial + ", valorCompra=" + valorCompra + ", estado=" + estado + ", tipo=" + tipo + "]";
	}

}