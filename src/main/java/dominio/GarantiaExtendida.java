package dominio;

import java.time.LocalDate;

public class GarantiaExtendida {

    private Producto producto;
    private LocalDate fechaSolicitudGarantia;
    private LocalDate fechaFinGarantia;
    private double precioGarantia;
    private String nombreCliente;

    public GarantiaExtendida(Producto producto) {
        this.fechaSolicitudGarantia = LocalDate.now();
        this.producto = producto;
    }

    public GarantiaExtendida(Producto producto, LocalDate fechaSolicitudGarantia, LocalDate fechaFinGarantia,
            double precioGarantia, String nombreCliente) {

        this.producto = producto;
        this.fechaSolicitudGarantia = fechaSolicitudGarantia;
        this.fechaFinGarantia = fechaFinGarantia;
        this.precioGarantia = precioGarantia;
        this.nombreCliente = nombreCliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public LocalDate getFechaSolicitudGarantia() {
        return fechaSolicitudGarantia;
    }

    public LocalDate getFechaFinGarantia() {
        return fechaFinGarantia;
    }

    public double getPrecioGarantia() {
        return precioGarantia;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

}
