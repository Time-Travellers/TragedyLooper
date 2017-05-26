package bbdd;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import presentacion.modelo.gameMastering.Reporte;
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
		file1.createNewFile();
		HashMap<String, Reporte> reportados = new HashMap<String, Reporte>();
	    new IO<Reporte>("reportados.ser").almacenar(reportados);
	}
	
}
