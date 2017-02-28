package Serializadas;
import java.io.Serializable;

public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int precio;
	
	public Producto(String nombre, int precio) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.precio = precio;
	}

}
