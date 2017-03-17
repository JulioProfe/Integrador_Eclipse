package Serializadas;
import java.io.Serializable;

public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String contrasena, name;
	public boolean registrado;
	
	public Usuario(String contrasena, String name, boolean registrado) {
		// TODO Auto-generated constructor stub
		this.contrasena = contrasena;
		this.name = name;
		this.registrado = registrado;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
