package integracion;

import bbdd.Gestor;
import presentacion.modelo.juego.InfoGuion;

public class DAO_Guiones extends DAO< InfoGuion >{

	public DAO_Guiones(Gestor g) {
		super(g);
	}
	
	@Override
	public void crear(InfoGuion obj) {
		gestor.guiones.put(obj.getTitulo(), obj);
	}

	@Override
	public InfoGuion leer(String id) {
		return gestor.guiones.get(id);
	}

	@Override
	public void actualizar(InfoGuion obj) {
		gestor.guiones.put(obj.getTitulo(), obj);
	}

	@Override
	public void borrar(String id) {
		gestor.guiones.remove(id);		
	}
}
