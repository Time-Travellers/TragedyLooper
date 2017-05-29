package presentacion.controlador.perfil;

public class PerfilEvent {
	public enum PrinciAdministradorType{
		Salir, Reportados, Mensajes, GuionesPropuestos,
		ActualizarPropuestos, ActualizarReportados, AtrasPropuestos, AtrasReportados
	}
	
	PrinciAdministradorType tipo;
	
	public PerfilEvent(PrinciAdministradorType t){
		tipo = t;
	}
	
	public String getPrinciAdministradorType(){
		return tipo.toString();
	}
}
