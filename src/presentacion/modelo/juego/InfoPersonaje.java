package presentacion.modelo.juego;

import java.io.Serializable;

public class InfoPersonaje implements Serializable{

	private static final long serialVersionUID = -7695189197594925678L;

	public enum Personaje {
		enfermera, policia, estudiante, monje, empresario
	}
	public enum Rol {
		asesino, conspirador, personaClave, amigo, amante
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
