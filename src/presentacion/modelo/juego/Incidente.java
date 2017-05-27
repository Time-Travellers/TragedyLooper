package presentacion.modelo.juego;

import java.util.ArrayList;
import java.util.List;

import presentacion.modelo.juego.InfoPersonaje.Personaje;

public class Incidente {
	
	public enum EnumIncidentes {
		No_Incidentes, Asesinato, Hospital, Suicidio, Desaparicion
	}
	
    public EnumIncidentes nombre;

    public Personaje culpable;

	public Incidente(EnumIncidentes nombre, Personaje culpable) {
		this.nombre = nombre;
		this.culpable = culpable;
	}
	
	public EnumIncidentes getIncidente(){
		return nombre;
	}
	
	public Personaje getCulpable(){
		return culpable;
	}

}
