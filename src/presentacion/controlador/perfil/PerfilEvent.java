package presentacion.controlador.perfil;

public class PerfilEvent {
	public enum PerfilType{
		Salir, CambiarPass, CambiarDatos, ListaAmigos
	}
	
	PerfilType tipo;
	
	public PerfilEvent(PerfilType t){
		tipo = t;
	}
	
	public String getPerfilType(){
		return tipo.toString();
	}
}
