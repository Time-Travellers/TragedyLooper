package integracion.DAO;

import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.usuario.Usuario;

public class DAO_Usuarios extends DAO< Usuario >{

	@Override
	public void crear(Usuario obj) {
		Gestor.getGestor().usuarios.put(obj.getId(), obj);
		Logger.getLogger("log").info("Acceso a BBDD de usuarios para crear objeto");
	}

	@Override
	public Usuario leer(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de usuarios para leer objeto");
		return Gestor.getGestor().usuarios.get(id);
	}

	@Override
	public void actualizar(Usuario obj) {
		Logger.getLogger("log").info("Acceso a BBDD de usuarios para actualizar objeto");
		Gestor.getGestor().usuarios.put(obj.getId(), obj);
	}

	@Override
	public void borrar(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de usuarios para borrar objeto");
		Gestor.getGestor().usuarios.remove(id);		
	}
		
	
	
}
