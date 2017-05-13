package tragedylooper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Jugador extends Usuario {
	
    private int nivel;
    private int reloj;
    private Date penalizacion;
    private List<JugadorPartida> partidas = new ArrayList<JugadorPartida> ();
    private Estadistica estadistica;
    private List<Jugador> amigos = new ArrayList<Jugador> ();
    private Rating rating;

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
//begin of modifiable zone(JavaCode)......C/7fe69736-e37c-4043-aaef-1227555096fc

//end of modifiable zone(JavaCode)........E/7fe69736-e37c-4043-aaef-1227555096fc
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

    public void comprarRelojes() {
//begin of modifiable zone(JavaCode)......C/5d38ad63-b366-4f81-9618-aa04b0abf5f2

//end of modifiable zone(JavaCode)........E/5d38ad63-b366-4f81-9618-aa04b0abf5f2
    }

}
