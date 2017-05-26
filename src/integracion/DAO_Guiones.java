package integracion;

import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.juego.InfoGuion;

public class DAO_Guiones extends DAO< InfoGuion >{

	public DAO_Guiones(Gestor g) {
		super(g);
	}
	
	@Override
	public void crear(InfoGuion obj) {
		gestor.guiones.put(obj.getTitulo(), obj);
		Logger.getLogger("log").info("Acceso a BBDD de guiones para crear objeto");
	}

	@Override
	public InfoGuion leer(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de guiones para leer objeto");
		return gestor.guiones.get(id);
	}

	@Override
	public void actualizar(InfoGuion obj) {
		gestor.guiones.put(obj.getTitulo(), obj);
		Logger.getLogger("log").info("Acceso a BBDD de guiones para actualizar objeto");

	}

	@Override
	public void borrar(String id) {
		gestor.guiones.remove(id);		
		Logger.getLogger("log").info("Acceso a BBDD de guiones para actualizar objeto");
	}
}
