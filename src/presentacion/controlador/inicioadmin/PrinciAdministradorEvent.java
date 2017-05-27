package presentacion.controlador.inicioadmin;

import presentacion.controlador.principalus.PrinciUsuarioEvent.PrinciUsuarioType;

public class PrinciAdministradorEvent {
	public enum PrinciAdministradorType{
		Salir, Reportados, Mensajes, GuionesPropuestos
	}
	
	PrinciUsuarioType tipo;
	
	public PrinciAdministradorEvent(PrinciUsuarioType t){
		tipo = t;
	}
	
	public String getPrinciAdministradorType(){
		return tipo.toString();
	}
}
