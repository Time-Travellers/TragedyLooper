package integracion;

import java.util.HashMap;
import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.juego.InfoGuion;

public class DAO_ListaGuionesPropuestos extends DAO<HashMap<String,InfoGuion>>{

	public DAO_ListaGuionesPropuestos(Gestor g) {
		super(g);
	}

	@Override
	public void crear(HashMap<String, InfoGuion> obj) {
		//Echar imaginacion
		gestor.reportados.put(obj, obj);
		Logger.getLogger("log").info("Acceso a BBDD de reportados para crear objeto");
	}

	@Override
	public HashMap<String, InfoGuion> leer(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de reportados para leer objeto");
		return gestor.guiones_propuestos;
	}

	@Override
	public void actualizar(HashMap<String, InfoGuion> obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(String id) {
		// TODO Auto-generated method stub
		
	}

}
