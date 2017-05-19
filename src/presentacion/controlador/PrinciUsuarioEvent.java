package presentacion.controlador;

import presentacion.controlador.IniSesionEvent.IniSesionType;

public class PrinciUsuarioEvent {
	
	public enum PrinciUsuarioType{
		BuscarUsuario, Ajustes, Ayuda, Salir, IniciarPartida,
		miPerfil, verRanking, comprarRelojes, comprarNivel, sugerencias,
		proponerGuion
	}
	
	PrinciUsuarioType tipo;
	
	public PrinciUsuarioEvent(PrinciUsuarioType t){
		tipo = t;
	}
	
	public String getPrinciUsuarioType(){
		return tipo.toString();
	}
	
}
