package bbdd;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.usuario.Administrador;
import presentacion.modelo.usuario.Datos;
import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Paises;
import presentacion.modelo.usuario.Usuario;

public class Modificador {
	
	static File file1 = new File("src/resources/reportados.ser");
	static File file2 = new File("src/resources/guiones_propuestos.ser");
	
	public static void main(String ... args) throws IOException {
		HashMap<String, Usuario> usuario = new IO<Usuario>("usuarios.ser").leer();
		usuario.put("admin1", new Administrador("admin1", "admin1", true, "Admin Uno", 99, Paises.España, "admin1@gmail.com"));
		usuario.remove("admin1");
	    new IO<Usuario>("usuarios.ser").almacenar(usuario);
	}
	
}
