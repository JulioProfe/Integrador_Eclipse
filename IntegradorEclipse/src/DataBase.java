import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Serializadas.Usuario;
import processing.data.XML;

public class DataBase {

	XML usuarios;
	File archivo;
	
	public DataBase(String ruta) {
		// TODO Auto-generated constructor stub
		archivo = new File(ruta);
		if (archivo.exists() && archivo.isFile()) {
			try {
				usuarios = new XML(archivo);
			} catch (IOException | ParserConfigurationException | SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			usuarios = new XML("usuarios");
			usuarios.addChild("usuario");
			usuarios.addChild("producto");
		}
	}
	
	public void guardar(){
		usuarios.save(archivo);
	}
	
	public void agregarUsuario(Usuario u){
		XML usuario = usuarios.getChild("usuario");
		XML newUsuario = usuario.addChild("user");
		newUsuario.setString("name", u.getName());
		newUsuario.setString("contrasena", u.getContrasena());
	}
	
	public ArrayList<Usuario> getUsuarios(){
		XML users = usuarios.getChild("usuario");
		ArrayList<Usuario> usersArray = new ArrayList<Usuario>();
		if (users.getChildCount()>0) {
			XML[] usuariosXML = users.getChildren("user");
			for (int i = 0; i < usuariosXML.length; i++) {
				String name = usuariosXML[i].getString("name");
				String contrasena = usuariosXML[i].getString("contrasena");
				
				usersArray.add(new Usuario(contrasena, name, true));
			}
		}
		return usersArray;
	}
	
}
