package presentacion.controlador.inicioadmin;

public class InicioAdministradorEvent {
	public enum PrinciAdministradorType {
		Salir, Reportados, Mensajes, GuionesPropuestos
	}

	PrinciAdministradorType tipo;

	public InicioAdministradorEvent(PrinciAdministradorType t) {
		tipo = t;
	}

	public String getPrinciAdministradorType() {
		return tipo.toString();
	}
}
