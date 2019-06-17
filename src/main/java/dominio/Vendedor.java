package dominio;

import java.time.DayOfWeek;
import java.time.LocalDate;

import dominio.excepcion.GarantiaExtendidaException;
import dominio.repositorio.RepositorioGarantiaExtendida;
import dominio.repositorio.RepositorioProducto;

public class Vendedor {

    public static final String EL_PRODUCTO_TIENE_GARANTIA = "El producto ya cuenta con una garantia extendida";
    public static final String EL_PRODUCTO_NO_CUENTA_CON_GARANTIA = "Este producto no cuenta con garantia extendida";

    private RepositorioProducto repositorioProducto;
    private RepositorioGarantiaExtendida repositorioGarantia;
    
    private final double PRECIO=500000;

    public Vendedor(RepositorioProducto repositorioProducto, RepositorioGarantiaExtendida repositorioGarantia) {
        this.repositorioProducto = repositorioProducto;
        this.repositorioGarantia = repositorioGarantia;

    }

    public void generarGarantia(String codigo, String nombreCliente) {

        if(!tieneGarantia(codigo)) {
        	if(cantidadVocales(codigo)!=3) {
        		Producto producto= this.repositorioProducto.obtenerPorCodigo(codigo);
        		GarantiaExtendida ga = null;
        		if(producto.getPrecio()>PRECIO) {
        			ga = new GarantiaExtendida(producto,
        					LocalDate.now(), obtenerFechaFinal200Dias(), producto.getPrecio()*0.2, nombreCliente);
        		}else {
        			ga = new GarantiaExtendida(producto,
        					LocalDate.now(), obtenerFechaFinal100Dias(), producto.getPrecio()*0.1, nombreCliente);
        		}
        		this.repositorioGarantia.agregar(ga);
        	}else {
        		throw new GarantiaExtendidaException(EL_PRODUCTO_NO_CUENTA_CON_GARANTIA);
        	}
        }else {
        	throw new GarantiaExtendidaException(EL_PRODUCTO_TIENE_GARANTIA);
        }

    }
    
    public int cantidadVocales(String codigo) {
    	codigo =codigo.toLowerCase();
    	int cantidad = 0;
    	for(int i=0;i<codigo.length();i++) {
    		if(codigo.charAt(i)=='a'){
    			cantidad++;
    		}
    		if(codigo.charAt(i)=='e'){
    			cantidad++;
    		}
    		if(codigo.charAt(i)=='i'){
    			cantidad++;
    		}
    		if(codigo.charAt(i)=='o'){
    			cantidad++;
    		}
    		if(codigo.charAt(i)=='u'){
    			cantidad++;
    		}
    	}
    	return cantidad;
    }

    public boolean tieneGarantia(String codigo) {
        return repositorioGarantia.obtenerProductoConGarantiaPorCodigo(codigo)!=null;
    }
    
    public LocalDate obtenerFechaFinal200Dias() {
    	
    	int dias = 200;
		LocalDate ld = LocalDate.now();

		for(int i=0;i<dias;i++) {
			
			if(ld.getDayOfWeek()==DayOfWeek.MONDAY) {
				dias++;
			}
			ld=ld.plusDays(1);
		}
		if(ld.getDayOfWeek()==DayOfWeek.SUNDAY) {
			ld=ld.plusDays(2);
		}
    	
        return ld;
    }

    public LocalDate obtenerFechaFinal100Dias() {
    	
    	int dias = 100;
		LocalDate ld = LocalDate.now();

		ld = ld.plusDays(dias);
    	
        return ld;
    		
     
    }

}
