package presentacion.modelo.juego;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JugadorPartida implements Serializable{
 
	private static final long serialVersionUID = 5090439596333989071L;

	public String rol;

    public Partida partida;

    public List<InfoCarta> carta = new ArrayList<InfoCarta> ();

    public void elegirCarta() {
    }

    public void usarHabilidad() {
    }

}
