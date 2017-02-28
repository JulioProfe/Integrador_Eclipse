import java.util.Observable;
import java.util.Observer;

import Serializadas.*;

public class Logica implements Observer {
	private Comunicacion com;

	public Logica() {
		// TODO Auto-generated constructor stub
		com = new Comunicacion();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
