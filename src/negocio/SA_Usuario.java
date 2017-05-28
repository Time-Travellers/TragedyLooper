package negocio;

import bbdd.Gestor;
import integracion.DAO_Usuarios;
import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Usuario;

public class SA_Usuario implements SA {

	public Usuario iniciarSesion(Gestor gestor, String id, String password) {
		Usuario usuario = new DAO_Usuarios(gestor).leer(id);
		if(usuario != null && !usuario.getPassword().equals(password))
			usuario = null;
		return usuario;
	}
	
	public boolean agregarUsuario(Gestor gestor, Usuario usuario) {
		Usuario aux = new DAO_Usuarios(gestor).leer(usuario.getId());
		if(aux == null)
			new DAO_Usuarios(gestor).crear(usuario);
		return aux == null;
	}
	
	 public void comprarRelojes(Gestor gestor, Jugador usuario, boolean anuncio, int relojes) {
	    	if(anuncio){
	    		usuario.setAnuncios(usuario.getAnuncios() - 1);
	    		usuario.setReloj(usuario.getReloj() + 1);
	    	}
	    	else{
	    		usuario.setReloj(usuario.getReloj() + relojes);
	    	}
	    	new DAO_Usuarios(gestor).actualizar(usuario);
	    }
	
}
