package presentacion.controlador.principalus;

import presentacion.modelo.usuario.Jugador;

public class PrinciUsuarioEvent {
	
	public enum PrinciUsuarioType{
		BuscarUsuario, Ajustes, Ayuda, Salir, IniciarPartida,
		miPerfil, verRanking, comprarRelojes, comprarNivel, sugerencias,
		proponerGuion
	}
	
	private PrinciUsuarioType tipo;
	
	public PrinciUsuarioEvent(PrinciUsuarioType t){
		tipo = t;
	}
	
	public String getPrinciUsuarioType(){
		return tipo.toString();
	}
}
