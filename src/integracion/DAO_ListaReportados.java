package integracion;

import java.util.HashMap;
import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.gameMastering.Reporte;

public class DAO_ListaReportados extends DAO <HashMap<String, Reporte>>{

	public DAO_ListaReportados(Gestor g) {
		super(g);
	}

	//Echar imaginacion
	@Override
	public void crear(HashMap<String, Reporte> obj) {
		gestor.reportados.put(obj, obj);
		Logger.getLogger("log").info("Acceso a BBDD de reportados para crear objeto");
	}

	@Override
	public HashMap<String, Reporte> leer(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de reportados para leer objeto");
		return gestor.reportados;
	}

	@Override
	public void actualizar(HashMap<String, Reporte> obj) {
		Logger.getLogger("log").info("Acceso a BBDD de reportados para actualizar objeto");
		gestor.reportados.put(obj.getHash(), obj);
	}

	@Override
	public void borrar(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de usuarios para borrar objeto");
		gestor.usuarios.remove(id);	
	}

}
