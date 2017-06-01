package presentacion.modelo.usuario;

import java.util.ArrayList;
import java.util.Date;
import presentacion.modelo.juego.JugadorPartida;
import presentacion.modelo.marketing.Tienda;
import presentacion.modelo.usuario.Paises;

public class Jugador extends Usuario {
	
	private static final long serialVersionUID = -7213910171949040945L;
	
	public static final int RECOMPENSA = 10;
	private int nivel;
    private int reloj;
    private int anuncios;
    private Date penalizacion;
    private ArrayList<JugadorPartida> partidas;
    private ArrayList<Jugador> amigos;
    
    public Jugador(String id, String password, boolean admin, String nombre, int edad, Paises pais, String correo) {
    	this.id = id;
    	this.password = password;
    	this.admin = admin;
    	this.datos = new Datos(nombre, edad, pais, correo);
    	this.nivel = 0;
    	this.reloj = 0;
    	this.anuncios = 3;
    	this.anuncios = Tienda.NUMANUNCIOS;
    	this.penalizacion = null;
    	this.partidas = new ArrayList<JugadorPartida>();
    	this.amigos = new ArrayList<Jugador>();
    }

    public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getReloj() {
		return reloj;
	}

	public void setReloj(int reloj) {
		this.reloj = reloj;
	}

	public Date getPenalizacion() {
		return penalizacion;
	}

	public void setPenalizacion(Date penalizacion) {
		this.penalizacion = penalizacion;
	}

	public ArrayList<JugadorPartida> getPartidas() {
		return partidas;
	}

	public void setPartidas(ArrayList<JugadorPartida> partidas) {
		this.partidas = partidas;
	}

	public ArrayList<Jugador> getAmigos() {
		return amigos;
	}

	public void setAmigos(ArrayList<Jugador> amigos) {
		this.amigos = amigos;
	}
	
    public int getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(int anuncios) {
		this.anuncios = anuncios;
	}

}
