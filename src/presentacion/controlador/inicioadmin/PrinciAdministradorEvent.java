package presentacion.controlador.inicioadmin;

public class PrinciAdministradorEvent {
	public enum PrinciAdministradorType{
		Salir, Reportados, Mensajes, GuionesPropuestos
	}
	
	PrinciAdministradorType tipo;
	
	public PrinciAdministradorEvent(PrinciAdministradorType t){
		tipo = t;
	}
	
	public String getPrinciAdministradorType(){
		return tipo.toString();
	}
}
