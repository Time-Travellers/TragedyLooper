package negocio;

import integracion.DAO_ListaGuionesPropuestos;
import integracion.DAO_ListaReportados;

import java.util.ArrayList;
import java.util.HashMap;

import presentacion.modelo.gameMastering.Reporte;
import presentacion.modelo.juego.InfoGuion;
import bbdd.Gestor;

public class SA_GameMastering implements SA {

	public ArrayList<Reporte> sacarReportados(Gestor g){
		ArrayList<Reporte>lista=new ArrayList<Reporte>();
		HashMap<String,Reporte> r=new DAO_ListaReportados(g).leer(null);
		return (ArrayList<Reporte>)r.values();
	}
	
	public ArrayList<InfoGuion> sacarGuiones(Gestor g){
		ArrayList<InfoGuion>lista=new ArrayList<InfoGuion>();
		HashMap<String, InfoGuion> r=new DAO_ListaGuionesPropuestos(g).leer(null);
		return (ArrayList<InfoGuion>)r.values();
	}
	
}
