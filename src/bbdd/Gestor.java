package bbdd;

import java.util.HashMap;

import tragedylooper.InfoGuion;
import tragedylooper.Jugador;
import tragedylooper.Partida;
import tragedylooper.Usuario;

public class Gestor {
    public HashMap<String, Usuario> usuario = new HashMap<String, Usuario>();

    public HashMap<String, Partida> partida = new HashMap<String, Partida> ();

    public HashMap<String, Jugador> listaEspera = new HashMap<String, Jugador> ();

    public HashMap<String, InfoGuion> guiones = new HashMap<String, InfoGuion> ();

 // public List<InfoLugar> lugares = new ArrayList<InfoLugar> ();
    
    public Gestor(){
    	usuario = new IO<Usuario>("usuarios.ser").leer();
    	//partida = new IO<Partida>("partidas.ser").leer();
    	guiones = new IO<InfoGuion>("guiones.ser").leer();
    	listaEspera = new IO<Jugador>("espera.ser").leer();
    }

}