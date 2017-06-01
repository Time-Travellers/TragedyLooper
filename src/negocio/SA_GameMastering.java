package negocio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import integracion.DAO.DAO_Guiones;
import integracion.DAO.DAO_Guiones_Propuestos;
import integracion.DAO.DAO_ListaGuionesPropuestos;
import integracion.DAO.DAO_ListaReportados;
import integracion.DAO.DAO_Reportados;
import integracion.DAO.DAO_Usuarios;
import presentacion.modelo.gameMastering.Reporte;
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.usuario.Jugador;

public class SA_GameMastering {

	public String[][] datosReportados() {
		HashMap<String, Reporte> r = new DAO_ListaReportados().leer();
		ArrayList<Reporte> reportes = new ArrayList<Reporte>(r.values());
		String[][] data = new String[reportes.size()][3];
		for (int i = 0; i < reportes.size(); ++i) {
			data[i][0] = reportes.get(i).getReportador().getId();
			data[i][1] = reportes.get(i).getReportado().getId();
			data[i][2] = new SimpleDateFormat("dd/M/yyyy").format(reportes.get(i).getFecha());
		}
		return data;
	}

	public void reportarJugador(Jugador reportador, Jugador reportado) {
		Reporte r = new Reporte(reportador, reportado, new Date());
		new DAO_Reportados().crear(r);
	}

	public String[][] datosGuionesPropuestos() {
		HashMap<String, InfoGuion> r = new DAO_ListaGuionesPropuestos().leer();
		ArrayList<InfoGuion> guiones = new ArrayList<InfoGuion>(r.values());
		String[][] data = new String[guiones.size()][3];
		for (int i = 0; i < guiones.size(); ++i) {
			data[i][0] = guiones.get(i).getCreador().getId();
			data[i][1] = guiones.get(i).getTitulo();
			data[i][2] = new SimpleDateFormat("dd/M/yyyy").format(guiones.get(i).getFecha());
		}
		return data;

	}
	
	public void aceptarGuion(String s, int nivel){
		InfoGuion guion = (new DAO_Guiones_Propuestos()).leer(s);
		guion.setNivel(nivel);
		(new DAO_Guiones_Propuestos()).borrar(s);
		(new DAO_Guiones()).crear(guion);
		Jugador jugador = guion.getCreador();
		jugador.setReloj(jugador.getReloj() + Jugador.RECOMPENSA);
		new DAO_Usuarios().actualizar(jugador);
	}
	
	public InfoGuion leerGuion(String s){
		return (new DAO_Guiones_Propuestos()).leer(s);
	}
	
	public void eliminarGuion(String s){
		new DAO_Guiones_Propuestos().borrar(s);
	}
	
	public int getNumReportados(){
		return new DAO_ListaReportados().leer().size();
	}
	
	public int getNumGuiones(){
		return new DAO_ListaGuionesPropuestos().leer().size();
	}
}
