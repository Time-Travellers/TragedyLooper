package integracion;

import bbdd.Gestor;
import presentacion.modelo.usuario.Jugador;

public class DAO_Espera extends DAO< Jugador >{

	public DAO_Espera(Gestor g) {
		super(g);
	}
	
	@Override
	public void crear(Jugador obj) {
		gestor.listaEspera.put(obj.getId(), obj);
	}

	@Override
	public Jugador leer(String id) {
		return gestor.listaEspera.get(id);
	}

	@Override
	public void actualizar(Jugador obj) {
		gestor.listaEspera.put(obj.getId(), obj);
	}

	@Override
	public void borrar(String id) {
		gestor.listaEspera.remove(id);		
	}
}
