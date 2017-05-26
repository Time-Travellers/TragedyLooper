package presentacion.modelo.juego;

import java.util.ArrayList;
import java.util.List;

public class Incidente {
	
	public enum Incidentes {
		No_Incidentes, Asesinato, Hospital, Suicidio, Desaparicion
	}
	
    public String nombre;

    public Accion accion;

    public List<InfoPersonaje> culpable = new ArrayList<InfoPersonaje> ();

}
