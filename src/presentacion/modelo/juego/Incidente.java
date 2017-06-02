package presentacion.modelo.juego;

import java.io.Serializable;

import presentacion.modelo.juego.InfoPersonaje.Personaje;

public class Incidente implements Serializable {

	private static final long serialVersionUID = -2666501810498361144L;

	public enum EnumIncidentes {
		No_Incidentes, Asesinato, Hospital, Suicidio, Desaparicion
	}

	public EnumIncidentes nombre;

	public Personaje culpable;

	public Incidente(EnumIncidentes nombre, Personaje culpable) {
		this.nombre = nombre;
		this.culpable = culpable;
	}

	public EnumIncidentes getIncidente() {
		return nombre;
	}

	public Personaje getCulpable() {
		return culpable;
	}

}
