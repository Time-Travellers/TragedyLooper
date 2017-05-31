package integracion;

import java.util.HashMap;
import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.usuario.Usuario;

public class DAO_ListaUsuarios extends DAO_Lista <HashMap<String, Usuario>>{

	public DAO_ListaUsuarios(Gestor g) {
		super(g);
	}
	@Override
	public HashMap<String, Usuario> leer() {
		Logger.getLogger("log").info("Acceso a BBDD de usuarios para leer objeto");
		return gestor.usuarios;
	}

}
