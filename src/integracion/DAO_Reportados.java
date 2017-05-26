package integracion;

import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.gameMastering.Reporte;

public class DAO_Reportados extends DAO< Reporte >{

	public DAO_Reportados(Gestor g) {
		super(g);
	}
	
	@Override
	public void crear(Reporte obj) {
		gestor.reportados.put(obj.getHash(), obj);
		Logger.getLogger("log").info("Acceso a BBDD de reportados para crear objeto");
	}

	@Override
	public Reporte leer(String hash) {
		Logger.getLogger("log").info("Acceso a BBDD de reportados para leer objeto");
		return gestor.reportados.get(hash);
	}

	@Override
	public void actualizar(Reporte obj) {
		Logger.getLogger("log").info("Acceso a BBDD de reportados para actualizar objeto");
		gestor.reportados.put(obj.getHash(), obj);
	}

	@Override
	public void borrar(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de usuarios para borrar objeto");
		gestor.usuarios.remove(id);		
	}
		
	
	
}
