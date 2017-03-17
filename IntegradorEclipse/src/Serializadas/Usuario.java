package Serializadas;
import java.io.Serializable;

public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String correo, contrasena, name;
	public boolean registrado;
	
	public Usuario(String correo, String contrasena, String name, boolean registrado) {
		// TODO Auto-generated constructor stub
		this.contrasena = contrasena;
		this.correo = correo;
		this.name = name;
		this.registrado = registrado;
	}

}
