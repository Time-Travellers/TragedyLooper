package integracion;

import bbdd.Gestor;
import tragedylooper.Usuario;

public class DAO_Usuario extends DAO< Usuario >{

	public DAO_Usuario(Gestor g) {
		super(g);
	}
	
	@Override
	public void crear(Usuario obj) {
		gestor.usuarios.put(obj.getId(), obj);
	}

	@Override
	public Usuario leer(String id) {
		return gestor.usuarios.get(id);
	}

	@Override
	public void actualizar(Usuario obj) {
		gestor.usuarios.put(obj.getId(), obj);
	}

	@Override
	public void borrar(String id) {
		gestor.usuarios.remove(id);		
	}
		
	
	
}
