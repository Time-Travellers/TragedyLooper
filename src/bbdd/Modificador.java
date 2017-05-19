package bbdd;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.usuario.Datos;
import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Paises;
import presentacion.modelo.usuario.Usuario;

public class Modificador {
	
	static File file1 = new File("src/resources/usuarios.ser");
	
	public static void main(String ... args) throws IOException {
		HashMap<String, Usuario> usuario = new IO<Usuario>("usuarios.ser").leer();
	    Usuario user = new Jugador("mar_ion", "mar_ion", false, "Marta", 17, Paises.Rumanía, "marta_ionescu@gmail.com");
	    usuario.put(user.getId(), user);
	    new IO<Usuario>("usuarios.ser").almacenar(usuario);
	    new IO<InfoGuion>("guiones.ser").almacenar(new HashMap<String, InfoGuion>());
	    new IO<Jugador>("espera.ser").almacenar(new HashMap<String, Jugador>());
	}
	
}
