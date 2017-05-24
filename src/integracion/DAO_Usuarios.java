package integracion;

import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.usuario.Usuario;

public class DAO_Usuarios extends DAO< Usuario >{

	public DAO_Usuarios(Gestor g) {
		super(g);
	}
	
	@Override
	public void crear(Usuario obj) {
		gestor.usuarios.put(obj.getId(), obj);
		Logger.getLogger("log").info("Acceso a BBDD de usuarios para crear objeto");
	}

	@Override
	public Usuario leer(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de usuarios para leer objeto");
		return gestor.usuarios.get(id);
	}

	@Override
	public void actualizar(Usuario obj) {
		Logger.getLogger("log").info("Acceso a BBDD de usuarios para actualizar objeto");
		gestor.usuarios.put(obj.getId(), obj);
	}

	@Override
	public void borrar(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de usuarios para borrar objeto");
		gestor.usuarios.remove(id);		
	}
		
	
	
}
