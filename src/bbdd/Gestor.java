package bbdd;

import java.util.HashMap;

import presentacion.modelo.gameMastering.Reporte;
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.usuario.Usuario;

public class Gestor {
	public HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();

	public HashMap<String, InfoGuion> guiones = new HashMap<String, InfoGuion>();

	public HashMap<String, Reporte> reportados = new HashMap<String, Reporte>();

	public HashMap<String, InfoGuion> guiones_propuestos = new HashMap<String, InfoGuion>();

	private static Gestor gestor;

	private Gestor() {
		cargar();
	}

	public static Gestor getGestor() {
		if (gestor == null)
			gestor = new Gestor();
		return gestor;
	}

	private void cargar() {
		usuarios = new IO<Usuario>("usuarios.ser").leer();
		guiones = new IO<InfoGuion>("guiones.ser").leer();
		reportados = new IO<Reporte>("reportados.ser").leer();
		guiones_propuestos = new IO<InfoGuion>("guiones_propuestos.ser").leer();
	}

	public void close() {
		new IO<Usuario>("usuarios.ser").almacenar(usuarios);
		new IO<InfoGuion>("guiones.ser").almacenar(guiones);
		new IO<Reporte>("reportados.ser").almacenar(reportados);
		new IO<InfoGuion>("guiones_propuestos.ser").almacenar(guiones_propuestos);
	}

}