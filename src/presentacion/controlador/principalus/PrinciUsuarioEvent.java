package presentacion.controlador.principalus;

import presentacion.modelo.usuario.Jugador;

public class PrinciUsuarioEvent {
	
	public enum PrinciUsuarioType{
		BuscarUsuario, Ajustes, Ayuda, Salir, IniciarPartida,
		miPerfil, verRanking, comprarRelojes, comprarNivel, sugerencias,
		proponerGuion
	}
	
	private PrinciUsuarioType tipo;
	private Jugador jugador;
	
	public PrinciUsuarioEvent(PrinciUsuarioType t){
		tipo = t;
	}
	public PrinciUsuarioEvent(PrinciUsuarioType t, Jugador j){
		tipo = t;
		jugador = j;
	}
	
	public String getPrinciUsuarioType(){
		return tipo.toString();
	}
	
	public Jugador getJugador(){
		return jugador;
	}
	
}
