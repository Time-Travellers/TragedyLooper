package negocio;

import bbdd.Gestor;
import integracion.DAO_Usuarios;
import presentacion.modelo.usuario.Usuario;

public class SA_Usuario implements SA {

	public Usuario iniciarSesion(Gestor gestor, String id, String password) {
		Usuario usuario = new DAO_Usuarios(gestor).leer(id);
		if(usuario != null && usuario.getPassword() != password)
			usuario = null;
		return usuario;
	}
	
}
