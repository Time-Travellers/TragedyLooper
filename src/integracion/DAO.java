package integracion;

import bbdd.Gestor;

public abstract class DAO < T >{
	
	
	protected Gestor gestor;
	
	public DAO(Gestor g) {
		this.gestor = g;
	}

	public abstract void crear(T obj);
	public abstract T leer(String id);
	public abstract void actualizar(T obj);
	public abstract void borrar(String id);
	
}
