package integracion;

import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.usuario.Usuario;

public class DAO_Guiones_Propuestos extends DAO< InfoGuion >{

	public DAO_Guiones_Propuestos(Gestor g) {
		super(g);
	}
	
	@Override
	public void crear(InfoGuion obj) {
		gestor.guiones_propuestos.put(obj.getTitulo(), obj);
		Logger.getLogger("log").info("Acceso a BBDD de guiones propuestos para crear objeto");
	}

	@Override
	public InfoGuion leer(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de guiones propuestos para leer objeto");
		return gestor.guiones_propuestos.get(id);
	}

	@Override
	public void actualizar(InfoGuion obj) {
		Logger.getLogger("log").info("Acceso a BBDD de guiones propuestos para actualizar objeto");
		gestor.guiones_propuestos.put(obj.getTitulo(), obj);
	}

	@Override
	public void borrar(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de guiones propuestos para borrar objeto");
		gestor.guiones_propuestos.remove(id);		
	}
		
	
	
}
