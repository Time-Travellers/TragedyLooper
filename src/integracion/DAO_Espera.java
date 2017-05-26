package integracion;

import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.usuario.Jugador;

public class DAO_Espera extends DAO< Jugador >{

	public DAO_Espera(Gestor g) {
		super(g);
	}
	
	@Override
	public void crear(Jugador obj) {
		gestor.listaEspera.put(obj.getId(), obj);
		Logger.getLogger("log").info("Acceso a BBDD de jugadores en espera para crear objeto");
	}

	@Override
	public Jugador leer(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de jugadores en espera para leer objeto");
		return gestor.listaEspera.get(id);
	}

	@Override
	public void actualizar(Jugador obj) {
		gestor.listaEspera.put(obj.getId(), obj);
		Logger.getLogger("log").info("Acceso a BBDD de jugadores en espera para actualizar objeto");
	}

	@Override
	public void borrar(String id) {
		gestor.listaEspera.remove(id);		
		Logger.getLogger("log").info("Acceso a BBDD de jugadores en espera para actualizar objeto");
	}
}
