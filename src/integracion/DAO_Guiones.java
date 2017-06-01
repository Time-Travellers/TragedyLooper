package integracion;

import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.juego.InfoGuion;

public class DAO_Guiones extends DAO< InfoGuion >{

	@Override
	public void crear(InfoGuion obj) {
		Gestor.getGestor().guiones.put(obj.getTitulo(), obj);
		Logger.getLogger("log").info("Acceso a BBDD de guiones para crear objeto");
	}

	@Override
	public InfoGuion leer(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de guiones para leer objeto");
		return Gestor.getGestor().guiones.get(id);
	}

	@Override
	public void actualizar(InfoGuion obj) {
		Gestor.getGestor().guiones.put(obj.getTitulo(), obj);
		Logger.getLogger("log").info("Acceso a BBDD de guiones para actualizar objeto");

	}

	@Override
	public void borrar(String id) {
		Gestor.getGestor().guiones.remove(id);		
		Logger.getLogger("log").info("Acceso a BBDD de guiones para actualizar objeto");
	}
}
