package presentacion.modelo.juego;

import java.io.Serializable;

public class InfoPersonaje implements Serializable{

	private static final long serialVersionUID = -7695189197594925678L;

	public enum Personaje {
		Enfermera, Policia, Estudiante, Monje, Empresario
	}
	public enum Rol {
		Asesino, Conspirador, PersonaClave, Amigo, Amante, Bruja
	}
	public Personaje nombre;
	public Rol rol;
	
	public InfoPersonaje(Personaje nombre, Rol rol){
		this.nombre = nombre;
		this.rol = rol;
	}
	
	public Personaje getNombre(){
		return nombre;
	}
	
	public Rol getRol(){
		return rol;
	}
}
