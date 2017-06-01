package negocio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import integracion.factorias.DAO_FactoryGuionesPropuestos;
import integracion.factorias.DAO_FactoryReportados;
import integracion.factorias.DAO_FactoryUsuarios;
import presentacion.modelo.gameMastering.Reporte;
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.usuario.Jugador;

public class SA_GameMastering {

	public String[][] datosReportados() {
		HashMap<String, Reporte> r = DAO_FactoryReportados.getFactoria().creaListaDAO().leer();
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
		DAO_FactoryReportados.getFactoria().creaDAO().crear(r);
	}

	public String[][] datosGuionesPropuestos() {
		HashMap<String, InfoGuion> r = 
				DAO_FactoryGuionesPropuestos.getFactoria().creaListaDAO().leer();
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
		InfoGuion guion = DAO_FactoryGuionesPropuestos.getFactoria().creaDAO().leer(s);
		guion.setNivel(nivel);
		DAO_FactoryGuionesPropuestos.getFactoria().creaDAO().borrar(s);
		DAO_FactoryGuionesPropuestos.getFactoria().creaDAO().crear(guion);
		Jugador jugador = guion.getCreador();
		jugador.setReloj(jugador.getReloj() + Jugador.RECOMPENSA);
		DAO_FactoryUsuarios.getFactoria().creaDAO().actualizar(jugador);
	}
	
	public InfoGuion leerGuion(String s){
		return DAO_FactoryGuionesPropuestos.getFactoria().creaDAO().leer(s);
	}
	
	public void eliminarGuion(String s){
		DAO_FactoryGuionesPropuestos.getFactoria().creaDAO().borrar(s);
	}
	
	public int getNumReportados(){
		return DAO_FactoryReportados.getFactoria().creaListaDAO().leer().size();
	}
	
	public int getNumGuiones(){
		return DAO_FactoryGuionesPropuestos.getFactoria().creaListaDAO().leer().size();
	}
}
