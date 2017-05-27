package presentacion.modelo.juego;

public class InfoPersonaje {

	public enum Personaje {
		enfermera, policia, estudiante, monje, empresario
	}
	public enum Rol {
		asesino, conspirador, personaClave, amigo, amante
	}
	public Personaje nombre;
	public Rol rol;
	
	public InfoPersonaje() {
	}
	
	public InfoPersonaje(Personaje nombre, Rol rol){
		this.nombre = nombre;
		this.rol = rol;
	}
}