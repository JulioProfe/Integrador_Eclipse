import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Observable;

public class Comunicacion extends Observable implements Runnable {
	
	private DatagramSocket ds;
	private final int Puerto = 5000;
	private String ipCliente = "226.8.8.6";
	private InetAddress ia;

	public Comunicacion() {
		// TODO Auto-generated constructor stub
		try {
			ds = new DatagramSocket(Puerto);
			ia = InetAddress.getByName(ipCliente);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	private Object deserializar(byte[] bytes) {
		Object data = null;
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			data = ois.readObject();

			// close streams
			ois.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}

	private byte[] serializar(Object data) {
		byte[] bytes = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(data);
			bytes = baos.toByteArray();

			// Close streams
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytes;
	}
	
	public void enviar(byte[] data){
		DatagramPacket packet = new DatagramPacket(data, data.length, ia, Puerto);
		try {
			ds.send(packet);
			System.out.println("ENVIADO");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mensaje (Object ob){
		byte[] serializado = serializar(ob);
		enviar(serializado);
	}
	
	public DatagramPacket recibir(){
		byte[] buffer = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		try {
			ds.receive(packet);
			System.out.println("RECIBIDO: " + packet.getAddress());
			ipCliente = packet.getAddress().toString();
			ia = packet.getAddress();
			return packet;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				if (ds != null) {
					DatagramPacket recibido = recibir();
					
					Object obRecibido = deserializar(recibido.getData());
					
					if (obRecibido != null) {
						setChanged();
						notifyObservers(obRecibido);
						clearChanged();;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	

}