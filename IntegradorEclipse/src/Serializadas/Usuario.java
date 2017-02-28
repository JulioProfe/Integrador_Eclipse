package Serializadas;
import java.io.Serializable;

public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String correo, contraseņa, name;
	private boolean registrado;
	
	public Usuario(String correo, String contraseņa, String name, boolean registrado) {
		// TODO Auto-generated constructor stub
		this.contraseņa = contraseņa;
		this.correo = correo;
		this.name = name;
		this.registrado = registrado;
	}

}
