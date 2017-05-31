package negocio;

import integracion.DAO_Guiones;
import integracion.DAO_Guiones_Propuestos;
import integracion.DAO_ListaGuionesPropuestos;
import integracion.DAO_ListaReportados;
import integracion.DAO_Reportados;
import integracion.DAO_Usuarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import presentacion.modelo.gameMastering.Reporte;
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Usuario;
import bbdd.Gestor;

public class SA_GameMastering {

	public ArrayList<Reporte> sacarReportados(Gestor g) {
		HashMap<String, Reporte> r = new DAO_ListaReportados(g).leer();
		return new ArrayList<Reporte>(r.values());
	}

	public ArrayList<InfoGuion> sacarGuiones(Gestor g) {
		HashMap<String, InfoGuion> r = new DAO_ListaGuionesPropuestos(g).leer();
		return new ArrayList<InfoGuion>(r.values());
	}

	public void reportarJugador(Gestor g, Jugador reportador, Jugador reportado) {
		Reporte r = new Reporte(reportador, reportado, new Date());
		new DAO_Reportados(g).crear(r);
	}

	public String[][] datosGuionesPropuestos(Gestor g) {
		HashMap<String, InfoGuion> r = new DAO_ListaGuionesPropuestos(g).leer();
		ArrayList<InfoGuion> guiones = new ArrayList<InfoGuion>(r.values());
		String[][] data = new String[guiones.size()][2];
		for (int i = 0; i < guiones.size(); ++i) {
			data[i][0] = guiones.get(i).getCreador().getId();
			data[i][1] = guiones.get(i).getTitulo();
		}
		return data;

	}
	
	public void aceptarGuion(Gestor g, String s, int nivel){
		InfoGuion guion = (new DAO_Guiones_Propuestos(g)).leer(s);
		guion.setNivel(nivel);
		(new DAO_Guiones_Propuestos(g)).borrar(s);
		(new DAO_Guiones(g)).crear(guion);
		Jugador jugador = guion.getCreador();
		jugador.setReloj(jugador.getReloj() + Jugador.RECOMPENSA);
		new DAO_Usuarios(g).actualizar(jugador);
	}
	
	public InfoGuion leerGuion(Gestor g, String s){
		return (new DAO_Guiones_Propuestos(g)).leer(s);
	}
	
	public void eliminarGuion(Gestor g, String s){
		(new DAO_Guiones_Propuestos(g)).borrar(s);
	}
}
