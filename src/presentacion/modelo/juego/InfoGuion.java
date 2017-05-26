package presentacion.modelo.juego;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InfoGuion implements Serializable{
	
	private static final long serialVersionUID = -2153228995875423399L;
	private String titulo;
	private int numLoops;
	private int numDias;
	private List<InfoPersonaje> cartaPersonaje = new ArrayList<InfoPersonaje>():
	private List<InfoPersonaje> infoPersonaje = new ArrayList<InfoPersonaje>();
	private Incidente incidente;
	private int nivel;

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

	public List<InfoPersonaje> getCartaPersonaje() {
		return cartaPersonaje;
	}

	public void setCartaPersonaje(List<InfoPersonaje> cartaPersonaje) {
		this.cartaPersonaje = cartaPersonaje;
	}

	public List<InfoPersonaje> getInfoPersonaje() {
		return infoPersonaje;
	}

	public void setInfoPersonaje(List<InfoPersonaje> infoPersonaje) {
		this.infoPersonaje = infoPersonaje;
	}

	public Incidente getIncidente() {
		return incidente;
	}

	public void setIncidente(Incidente incidente) {
		this.incidente = incidente;
	}
	
	public void setNivel(int nivel){
		this.nivel=nivel;
	}

}
