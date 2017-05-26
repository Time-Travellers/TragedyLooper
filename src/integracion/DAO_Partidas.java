package integracion;

import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.juego.Partida;

public class DAO_Partidas extends DAO<Partida>{
	
	public DAO_Partidas(Gestor g) {
		super(g);
	}
	
	@Override
	public void crear(Partida obj) {
		gestor.partidas.put(obj.getId(), obj);
		Logger.getLogger("log").info("Acceso a BBDD de partidas para crear objeto");
	}

	@Override
	public Partida leer(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de partidas para leer objeto");
		return gestor.partidas.get(id);
	}

	@Override
	public void actualizar(Partida obj) {
		gestor.partidas.put(obj.getId(), obj);
		Logger.getLogger("log").info("Acceso a BBDD de partidas para actualizar objeto");
	}

	@Override
	public void borrar(String id) {
		gestor.partidas.remove(id);	
		Logger.getLogger("log").info("Acceso a BBDD de partidas para borrar objeto");
	}
}
