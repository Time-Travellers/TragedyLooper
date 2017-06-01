package integracion;

import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.juego.InfoGuion;

public class DAO_Guiones_Propuestos extends DAO< InfoGuion >{
	
	@Override
	public void crear(InfoGuion obj) {
		Gestor.getGestor().guiones_propuestos.put(obj.getTitulo(), obj);
		Logger.getLogger("log").info("Acceso a BBDD de guiones propuestos para crear objeto");
	}

	@Override
	public InfoGuion leer(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de guiones propuestos para leer objeto");
		return Gestor.getGestor().guiones_propuestos.get(id);
	}

	@Override
	public void actualizar(InfoGuion obj) {
		Logger.getLogger("log").info("Acceso a BBDD de guiones propuestos para actualizar objeto");
		Gestor.getGestor().guiones_propuestos.put(obj.getTitulo(), obj);
	}

	@Override
	public void borrar(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de guiones propuestos para borrar objeto");
		Gestor.getGestor().guiones_propuestos.remove(id);		
	}
	
}
