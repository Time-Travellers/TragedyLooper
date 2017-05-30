package presentacion.modelo.juego;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import presentacion.modelo.usuario.Jugador;

public class InfoGuion implements Serializable{
	
	public enum Trama{
		Un_lugar_que_proteger, Luz_del_vengador, Masacre_en_Rokkenjima
	}
	
	public enum Subtrama{
		La_bruja_dorada, Un_rumor_inquietante, Amor_prohibido
	}
	
	private static final long serialVersionUID = -2153228995875423399L;
	private String titulo;
	private Trama trama;
	public Subtrama subtrama;
	private int numLoops;
	private int numDias;
	private List<InfoPersonaje> cartaPersonajes = new ArrayList<InfoPersonaje>();
	private List<Incidente> incidentes;
	private int nivel;
	private Jugador creador;
	

	public InfoGuion(Jugador creador, String titulo, Trama trama, Subtrama subtrama,
			int numLoops, int numDias, List<InfoPersonaje> cartaPersonajes,
			List<Incidente> incidentes) {
		this.creador=creador;
		this.titulo = titulo;
		this.trama = trama;
		this.subtrama = subtrama;
		this.numLoops = numLoops;
		this.numDias = numDias;
		this.cartaPersonajes = cartaPersonajes;
		this.incidentes = incidentes;
		this.creador=creador;
	}

	
	public Jugador getCreador(){
		return this.creador;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumLoops() {
		return numLoops;
	}

	public Trama getTrama(){
		return trama;
	}
	
	public Subtrama getSubtrama(){
		return subtrama;
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

	public void setCartaPersonajes(List<InfoPersonaje> cartaPersonaje) {
		this.cartaPersonajes = cartaPersonaje;
	}

	public List<InfoPersonaje> getInfoPersonajes() {
		return cartaPersonajes;
	}

	public void setInfoPersonajes(List<InfoPersonaje> infoPersonaje) {
		this.cartaPersonajes = infoPersonaje;
	}

	public List<Incidente> getIncidentes() {
		return incidentes;
	}

	public void setIncidentes(List<Incidente> incidentes) {
		this.incidentes = incidentes;
	}
	
	public void setNivel(int nivel){
		this.nivel=nivel;
	}
	
	public int getNivel(){
		return nivel;
	}
	
	
}
