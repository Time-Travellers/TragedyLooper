package integracion;

import bbdd.Gestor;
import tragedylooper.Partida;

public class DAO_Partidas extends DAO<Partida>{
	
	public DAO_Partidas(Gestor g) {
		super(g);
	}
	
	@Override
	public void crear(Partida obj) {
		gestor.partidas.put(obj.getId(), obj);
	}

	@Override
	public Partida leer(String id) {
		return gestor.partidas.get(id);
	}

	@Override
	public void actualizar(Partida obj) {
		gestor.partidas.put(obj.getId(), obj);
	}

	@Override
	public void borrar(String id) {
		gestor.partidas.remove(id);		
	}
}
