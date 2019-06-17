package persistencia.entitad;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity(name = "GarantiaExtendida")
@NamedQuery(name = "GarantiaExtendida.findByCodigo", query = "SELECT garantia from GarantiaExtendida garantia where garantia.producto.codigo = :codigo")
public class GarantiaExtendidaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "id")
	private ProductoEntity producto;

	private LocalDate fechaSolicitudGarantia;

	private LocalDate fechaFinGarantia;

	private String nombreCliente;

	private double precio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	public LocalDate getFechaSolicitudGarantia() {
		return fechaSolicitudGarantia;
	}

	public void setFechaSolicitudGarantia(LocalDate fechaSolicitudGarantia) {
		this.fechaSolicitudGarantia = fechaSolicitudGarantia;
	}

	public LocalDate getFechaFinGarantia() {
		return fechaFinGarantia;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public double getPrecio() {
		return precio;
	}

}
