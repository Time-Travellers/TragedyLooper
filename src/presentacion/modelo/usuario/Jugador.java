package presentacion.modelo.usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import presentacion.modelo.juego.JugadorPartida;
import presentacion.modelo.juego.Partida;
import presentacion.modelo.marketing.Tienda;
import presentacion.modelo.usuario.Paises;

public class Jugador extends Usuario {
	
	private static final long serialVersionUID = -7213910171949040945L;
	private int nivel;
    private int reloj;
    private int anuncios;
    private Date penalizacion;
    private List<JugadorPartida> partidas;
    private Estadistica estadistica;
    private List<Jugador> amigos;
    private Rating rating;
    
    public Jugador(String id, String password, boolean admin, String nombre, int edad, Paises pais, String correo) {
    	this.id = id;
    	this.password = password;
    	this.admin = admin;
    	this.datos = new Datos(nombre, edad, pais, correo);
    	this.nivel = 0;
    	this.reloj = 0;
    	this.anuncios = Tienda.NUMANUNCIOS;
    	this.penalizacion = null;
    	this.partidas = new ArrayList<JugadorPartida>();
    	this.estadistica = null;
    	this.amigos = new ArrayList<Jugador>();
    	this.rating = null;
    }

    public void anyadirAmigo(Jugador jugador) {
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

	public List<JugadorPartida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<JugadorPartida> partidas) {
		this.partidas = partidas;
	}

	public Estadistica getEstadistica() {
		return estadistica;
	}

	public void setEstadistica(Estadistica estadistica) {
		this.estadistica = estadistica;
	}

	public List<Jugador> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<Jugador> amigos) {
		this.amigos = amigos;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public void ComenzarPartida() {
    }

    public void comprarNivel() {
    }

    public void jugarPartida() {
//begin of modifiable zone(JavaCode)......C/6ffed2ed-a37c-42cf-a548-6fe95685c95e

//end of modifiable zone(JavaCode)........E/6ffed2ed-a37c-42cf-a548-6fe95685c95e
    }

    public void abandonarPartida() {
//begin of modifiable zone(JavaCode)......C/fdfdfe15-e2f1-4412-8d0b-b3d455ab383c

//end of modifiable zone(JavaCode)........E/fdfdfe15-e2f1-4412-8d0b-b3d455ab383c
    }

    public void contactarAdmin() {
    }

    public boolean eliminarAmigo(Jugador amigo) {
//begin of modifiable zone(JavaCode)......C/704d5a71-0451-4992-a423-9570c81035d3

//end of modifiable zone(JavaCode)........E/704d5a71-0451-4992-a423-9570c81035d3
//begin of modifiable zone(JavaReturned)..C/704d5a71-0451-4992-a423-9570c81035d3

//end of modifiable zone(JavaReturned)....E/704d5a71-0451-4992-a423-9570c81035d3
    }

    public String verPerfil() {
//begin of modifiable zone(JavaCode)......C/1c454b01-00b8-44d4-9937-6348870e478e

//end of modifiable zone(JavaCode)........E/1c454b01-00b8-44d4-9937-6348870e478e
//begin of modifiable zone(JavaReturned)..C/1c454b01-00b8-44d4-9937-6348870e478e

//end of modifiable zone(JavaReturned)....E/1c454b01-00b8-44d4-9937-6348870e478e
    }

    public void actualizar(Partida partida) {
//begin of modifiable zone(JavaCode)......C/b2d1642e-1404-426b-87c1-af40a83e8292

//end of modifiable zone(JavaCode)........E/b2d1642e-1404-426b-87c1-af40a83e8292
    }

    public void comprarRelojes(boolean anuncio, int relojes) {
    	if(anuncio){
    		--anuncios;
    		++reloj;
    	}
    	else{
    		reloj+=relojes;
    	}
    }
    
    public boolean anunciosDisponibles(){
    	return anuncios>0;
    }

}
