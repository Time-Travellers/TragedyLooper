package bbdd;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import presentacion.modelo.gameMastering.Reporte;
import presentacion.modelo.juego.Incidente;
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.juego.InfoPersonaje;
import presentacion.modelo.juego.InfoGuion.Subtrama;
import presentacion.modelo.juego.InfoGuion.Trama;
import presentacion.modelo.usuario.Administrador;
import presentacion.modelo.usuario.Datos;
import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Paises;
import presentacion.modelo.usuario.Usuario;

public class Modificador {
	
	static File file1 = new File("src/resources/usuarios.ser");
	static File file2 = new File("src/resources/guiones_propuestos.ser");
	
	public static void main(String ... args) throws IOException {
		//file1.createNewFile();
		//HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
		//usuarios.put("admin1", new Administrador("admin1", "admin1", true, "Administrador 1", 100, Paises.China, "admin1@gmail.com"));
	    //new IO<Usuario>("usuarios.ser").almacenar(usuarios);
		
		//HashMap<String, InfoGuion> guiones = new IO<InfoGuion>("guiones.ser").leer();
		//guiones.remove("Festival del algodon");
		//new IO<InfoGuion>("guiones.ser").almacenar(guiones);
		
		file2.createNewFile();
		HashMap<String, InfoGuion> guiones = new HashMap<String, InfoGuion>();
		new IO<InfoGuion>("guiones_propuestos.ser").almacenar(guiones);
	}
	
}
