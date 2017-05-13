package tragedylooper;

import java.util.ArrayList;
import java.util.List;

public class Partida {
	private String id;
	
    private int loop;

    private int dia;

    private boolean terminada;

    private String ganador;

    private String turno;

    private InfoGuion guiones;

    private EstadoPersonaje personaje;

    private List<Jugador> jugadores = new ArrayList<Jugador> ();

    private List<EstadoLugar> estadoLugar = new ArrayList<EstadoLugar> ();

    private InfoGuion guion;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLoop() {
		return loop;
	}

	public void setLoop(int loop) {
		this.loop = loop;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public boolean isTerminada() {
		return terminada;
	}

	public void setTerminada(boolean terminada) {
		this.terminada = terminada;
	}

	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public InfoGuion getGuiones() {
		return guiones;
	}

	public void setGuiones(InfoGuion guiones) {
		this.guiones = guiones;
	}

	public EstadoPersonaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(EstadoPersonaje personaje) {
		this.personaje = personaje;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public List<EstadoLugar> getEstadoLugar() {
		return estadoLugar;
	}

	public void setEstadoLugar(List<EstadoLugar> estadoLugar) {
		this.estadoLugar = estadoLugar;
	}

	public InfoGuion getGuion() {
		return guion;
	}

	public void setGuion(InfoGuion guion) {
		this.guion = guion;
	}

	public Accion aplicarJugada() {
    }

    public Accion habilidadesMaster() {
    }

    public Accion habilidadesBondad() {
    }

    public void avisarJugadores() {
    }

    public void checkPerdida() {
    }

}
