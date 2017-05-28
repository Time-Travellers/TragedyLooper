package presentacion.modelo;

import presentacion.modelo.usuario.Usuario;

public class GUIModelo{
	
	private Usuario usuario;
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getIdUsuario(){
		return usuario.getId();
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
}
