package negocio;

import integracion.DAO_ListaGuionesPropuestos;
import integracion.DAO_ListaReportados;

import java.util.ArrayList;
import java.util.HashMap;

import presentacion.modelo.gameMastering.Reporte;
import presentacion.modelo.juego.InfoGuion;
import bbdd.Gestor;

public class SA_GameMastering{

	public ArrayList<Reporte> sacarReportados(Gestor g){
		HashMap<String,Reporte> r=new DAO_ListaReportados(g).leer();
		return new ArrayList<Reporte> (r.values());
	}
	
	public ArrayList<InfoGuion> sacarGuiones(Gestor g){
		HashMap<String, InfoGuion> r=new DAO_ListaGuionesPropuestos(g).leer();
		return new ArrayList<InfoGuion> (r.values());
	}
	
}
