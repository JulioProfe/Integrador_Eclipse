package Serializadas;
import java.io.Serializable;

public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String correo, contrase�a, name;
	private boolean registrado;
	
	public Usuario(String correo, String contrase�a, String name, boolean registrado) {
		// TODO Auto-generated constructor stub
		this.contrase�a = contrase�a;
		this.correo = correo;
		this.name = name;
		this.registrado = registrado;
	}

}
