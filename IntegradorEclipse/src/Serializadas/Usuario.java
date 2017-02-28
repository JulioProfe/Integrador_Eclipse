package Serializadas;
import java.io.Serializable;

public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String correo, contraseña, name;
	private boolean registrado;
	
	public Usuario(String correo, String contraseña, String name, boolean registrado) {
		// TODO Auto-generated constructor stub
		this.contraseña = contraseña;
		this.correo = correo;
		this.name = name;
		this.registrado = registrado;
	}

}
