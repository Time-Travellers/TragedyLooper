package integracion;

import bbdd.Gestor;
import presentacion.modelo.usuario.Usuario;

public class DAO_Usuarios extends DAO< Usuario >{

	public DAO_Usuarios(Gestor g) {
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
