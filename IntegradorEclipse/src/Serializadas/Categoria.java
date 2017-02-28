package Serializadas;
import java.io.Serializable;

public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeroCat, nombreCat;
	
	public Categoria(String numeroCat, String nombreCat) {
		// TODO Auto-generated constructor stub
		this.numeroCat = numeroCat;
		this.nombreCat = nombreCat;
	}

}
