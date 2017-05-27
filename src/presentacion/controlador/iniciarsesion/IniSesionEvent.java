package presentacion.controlador.iniciarsesion;

public class IniSesionEvent {
	
	public enum IniSesionType{
		IniciarSesion,
		DarseAlta
	}
	private String usuario;
	private String contrasena;
	private IniSesionType tipo;
	
	public IniSesionEvent(IniSesionType t){
		tipo = t;
		usuario = "";
		contrasena = "";
	}
	
	public IniSesionEvent(IniSesionType t, String u, String c){
		tipo = t;
		usuario = u;
		contrasena = c;
	}
	
	public String getIniSesionType(){
		return tipo.toString();
	}
	
	public String getUsuario(){
		return usuario;
	}
	
	public String getContrasena(){
		return contrasena;
	}
}
