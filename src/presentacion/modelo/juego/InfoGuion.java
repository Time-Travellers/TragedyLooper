package presentacion.modelo.juego;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InfoGuion implements Serializable{
	
	private static final long serialVersionUID = -2153228995875423399L;
	private String titulo;
	private int numLoops;
	private int numDias;
	private List<InfoPersonaje> cartaPersonajes = new ArrayList<InfoPersonaje>();
	private List<InfoPersonaje> infoPersonajes = new ArrayList<InfoPersonaje>();
	private List<Incidente> incidentes;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumLoops() {
		return numLoops;
	}

	public void setNumLoops(int numLoops) {
		this.numLoops = numLoops;
	}

	public int getNumDias() {
		return numDias;
	}

	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}

	public List<InfoPersonaje> getCartaPersonajes() {
		return cartaPersonajes;
	}

	public void setCartaPersonajes(List<InfoPersonaje> cartaPersonaje) {
		this.cartaPersonajes = cartaPersonaje;
	}

	public List<InfoPersonaje> getInfoPersonajes() {
		return infoPersonajes;
	}

	public void setInfoPersonajes(List<InfoPersonaje> infoPersonaje) {
		this.infoPersonajes = infoPersonaje;
	}

	public List<Incidente> getIncidentes() {
		return incidentes;
	}

	public void setIncidentes(List<Incidente> incidentes) {
		this.incidentes = incidentes;
	}

}
