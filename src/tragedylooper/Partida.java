package tragedylooper;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    public int loop;

    public int dia;

    public boolean terminada;

    public String ganador;

    public String turno;

    public InfoGuion guiones;

    public EstadoPersonaje personaje;

    public List<Jugador> jugadores = new ArrayList<Jugador> ();

    public List<EstadoLugar> estadoLugar = new ArrayList<EstadoLugar> ();

    public InfoGuion guion;

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
