package negocio;

import bbdd.Gestor;
import integracion.DAO_Usuarios;
import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Paises;
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

	public boolean cambiarPass(Gestor gestor, Jugador jugador, String old, String pass) {
		if(!jugador.getPassword().equals(old))
			return false;
		else {
			jugador.setPassword(pass);
			new DAO_Usuarios(gestor).actualizar(jugador);
			return true;
		}
	}

	public void modifDatos(Gestor gestor, Jugador jugador, String email, int edad, Paises pais) {
		jugador.getDatos().setCorreo(email);
		jugador.getDatos().setEdad(edad);
		jugador.getDatos().setPais(pais);
		new DAO_Usuarios(gestor).actualizar(jugador);
	}
	
}
