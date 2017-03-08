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

						String productos[] = new String[3];
						
						productos[0] = "";
						productos[1] = "";
						productos[2] = "";
						
						float[] precios = new float[3];

						precios[0] = 1000;
						precios[1] = 2000;
						precios[2] = 3000;

						String prodDos[] = new String[3];
						
						prodDos[0] = "";
						prodDos[1] = "";
						prodDos[2] = "";
						
						float[] prodDosPrecio = new float[3];

						prodDosPrecio[0] = 2000;
						prodDosPrecio[1] = 3000;
						prodDosPrecio[2] = 4000;
					}
				}
			}
		}
	}
	// shi
}
