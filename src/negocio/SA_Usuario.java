package negocio;

import java.util.ArrayList;
import java.util.HashMap;

import integracion.DAO.DAO_Usuarios;
import integracion.factorias.DAO_FactoryUsuarios;
import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Paises;
import presentacion.modelo.usuario.Usuario;

public class SA_Usuario{
	
	public Usuario iniciarSesion(String id, String password) {
		Usuario usuario = DAO_FactoryUsuarios.getFactoria().creaDAO().leer(id);
		if(usuario != null && !usuario.getPassword().equals(password))
			usuario = null;
		return usuario;
	}
	
	public boolean agregarUsuario(Usuario usuario) {
		Usuario aux = new DAO_Usuarios().leer(usuario.getId());
		if(aux == null)
			DAO_FactoryUsuarios.getFactoria().creaDAO().crear(usuario);
		return aux == null;
	}

	public boolean cambiarPass(Jugador jugador, String old, String pass) {
		if(!jugador.getPassword().equals(old))
			return false;
		else {
			jugador.setPassword(pass);
			DAO_FactoryUsuarios.getFactoria().creaDAO().actualizar(jugador);
			return true;
		}
	}

	public void modifDatos(Jugador jugador, String email, int edad, Paises pais) {
		jugador.getDatos().setCorreo(email);
		jugador.getDatos().setEdad(edad);
		jugador.getDatos().setPais(pais);
		DAO_FactoryUsuarios.getFactoria().creaDAO().actualizar(jugador);
	}
	
	public boolean agregarAmigo(Jugador jugador, Jugador amigo) {
		if(jugador.getAmigos().contains(amigo))
			return false;
		else {
			jugador.getAmigos().add(amigo);
			DAO_FactoryUsuarios.getFactoria().creaDAO().actualizar(jugador);
			return true;
		}
	}
	
	public ArrayList<Jugador> buscarUsuario(String jugador, String str){
		HashMap<String, Usuario> usuariosHM = DAO_FactoryUsuarios.getFactoria().creaListaDAO().leer();
		ArrayList<Usuario> usuariosAL = new ArrayList<Usuario>(usuariosHM.values());
		ArrayList<Jugador> results = new ArrayList<Jugador>();
		for(Usuario a: usuariosAL) {
			if(!a.getId().equals(jugador) && !a.isAdmin() && a.getId().contains(str))
				results.add((Jugador) a);
		}
		return results;
	}

	public boolean borrarAmigo(Jugador jugador, Jugador amigo) {
		if(jugador.getAmigos().contains(amigo)) {
			jugador.getAmigos().remove(amigo);
			DAO_FactoryUsuarios.getFactoria().creaDAO().actualizar(jugador);
			return true;
		} else {
			return false;
		}
	}
	
}
