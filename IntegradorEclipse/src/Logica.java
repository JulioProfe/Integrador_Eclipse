import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Serializadas.*;

public class Logica implements Observer {
	private Comunicacion com;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Producto> productos;

	public Logica() {
		// TODO Auto-generated constructor stub
		com = new Comunicacion();
		com.addObserver(this);
		new Thread(com).start();
		usuarios = new ArrayList<>();
		productos = new ArrayList<>();
	}

	@Override
	public void update(Observable o, Object obj) {
		// TODO Auto-generated method stub
		Object recibido = obj;
		if (recibido instanceof Usuario) {
			Usuario shi = (Usuario) recibido;

			if (shi.registrado) {
				
				usuarios.add(shi);
				String hecho = new String("RegistroAproado");
				com.mensaje(hecho);
				
			} else if (!usuarios.isEmpty()) {
				for (int i = 0; i < usuarios.size(); i++) {
					Usuario registrados = usuarios.get(i);

					if (registrados.name.equals(shi.name) & registrados.contraseña.equals(shi.contraseña)) {
						String logueado = new String("LoginAprobado");
						com.mensaje(logueado);
						
						productos.add(new Producto("palomas", "paloma1", 1000));
						productos.add(new Producto("palomas", "paloma2", 2000));
						productos.add(new Producto("palomas", "paloma3", 3000));
						productos.add(new Producto("prro", "prro1", 4000));
						productos.add(new Producto("prro", "prro2", 5000));
						productos.add(new Producto("prro", "prro3", 6000));
						com.mensaje(productos);
					} else if (!shi.registrado) {
						System.out.println("Contraseña o usuario incorrecto");
						String fallo = new String("LoginNoAprobado");
						com.mensaje(fallo);
					}
				}
			} else {
				System.out.println("Usuario o registrado");
				String noRegistro = new String ("LoginNoAprobado");
				com.mensaje(noRegistro);
			}
		}
	}
	// shi
}
