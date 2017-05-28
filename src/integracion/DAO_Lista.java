package integracion;

import bbdd.Gestor;

public abstract class DAO_Lista < T >{
	
protected Gestor gestor;

	public DAO_Lista(Gestor g) {
		this.gestor = g;
	}

	public abstract T leer();
}
