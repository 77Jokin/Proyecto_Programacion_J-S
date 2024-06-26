package modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


/**
 * The persistent class for the proyectos database table.
 * 
 */
@Entity
@Table(name="proyectos")
@NamedQuery(name="Proyecto.findAll", query="SELECT p FROM Proyecto p")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_proyecto")
	private String idProyecto;

	@Column(name="coste_real")
	private BigDecimal costeReal;

	@Column(name="costes_previsto")
	private BigDecimal costesPrevisto;

	private String descripcion;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_previsto")
	private Date fechaFinPrevisto;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_real")
	private Date fechaFinReal;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Column(name="venta_previsto")
	private BigDecimal ventaPrevisto;

	//uni-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cif")
	private Cliente cliente;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="jefe_proyecto")
	private Empleado empleado;

	public Proyecto(String idProyecto, BigDecimal costeReal, BigDecimal costesPrevisto, String descripcion,
			String estado, Date fechaFinPrevisto, Date fechaFinReal, Date fechaInicio, BigDecimal ventaPrevisto,
			Cliente cliente, Empleado empleado) {
		super();
		this.idProyecto = idProyecto;
		this.costeReal = costeReal;
		this.costesPrevisto = costesPrevisto;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaFinPrevisto = fechaFinPrevisto;
		this.fechaFinReal = fechaFinReal;
		this.fechaInicio = fechaInicio;
		this.ventaPrevisto = ventaPrevisto;
		this.cliente = cliente;
		this.empleado = empleado;
	}

	public Proyecto() {
	}

	public String getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public BigDecimal getCosteReal() {
		return this.costeReal;
	}

	public void setCosteReal(BigDecimal costeReal) {
		this.costeReal = costeReal;
	}

	public BigDecimal getCostesPrevisto() {
		return this.costesPrevisto;
	}

	public void setCostesPrevisto(BigDecimal costesPrevisto) {
		this.costesPrevisto = costesPrevisto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFinPrevisto() {
		return this.fechaFinPrevisto;
	}

	public void setFechaFinPrevisto(Date fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}

	public Date getFechaFinReal() {
		return this.fechaFinReal;
	}

	public void setFechaFinReal(Date fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public BigDecimal getVentaPrevisto() {
		return this.ventaPrevisto;
	}

	public void setVentaPrevisto(BigDecimal ventaPrevisto) {
		this.ventaPrevisto = ventaPrevisto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProyecto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Proyecto))
			return false;
		Proyecto other = (Proyecto) obj;
		return Objects.equals(idProyecto, other.idProyecto);
	}

	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", costeReal=" + costeReal + ", costesPrevisto=" + costesPrevisto
				+ ", descripcion=" + descripcion + ", estado=" + estado + ", fechaFinPrevisto=" + fechaFinPrevisto
				+ ", fechaFinReal=" + fechaFinReal + ", fechaInicio=" + fechaInicio + ", ventaPrevisto=" + ventaPrevisto
				+ ", cliente=" + cliente + ", empleado=" + empleado + "]";
	}
	
	
	public double margenPrevisto() {
		//Importe de venta – coste previsto
		return ventaPrevisto.doubleValue() - costesPrevisto.doubleValue();

	}

	public double margenReal() { 
		//Importe de venta – gastos reales
		return ventaPrevisto.doubleValue() - costeReal.doubleValue();

	}

	public double diferenciaGastos() {
		//Gasto real – gasto previsto
		return costeReal.doubleValue() - costesPrevisto.doubleValue();

	}

	public double diferenciaFinPrevistoReal(){ 
		// Días entre fin previsto y fin real
		long diferencia = fechaFinReal.getTime() - fechaFinPrevisto.getTime();
        return (double) diferencia / (24 * 60 * 60 * 1000); 
	}
}