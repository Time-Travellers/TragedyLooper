package bbdd;

import java.util.ArrayList;
import java.util.List;

import tragedylooper.InfoGuion;
import tragedylooper.Jugador;
import tragedylooper.Partida;
import tragedylooper.Usuario;

public class Gestor {
    public List<Usuario> usuario = new ArrayList<Usuario> ();

    public List<Partida> partida = new ArrayList<Partida> ();

    public List<Jugador> listaEspera = new ArrayList<Jugador> ();

    public List<InfoGuion> guiones = new ArrayList<InfoGuion> ();

 // public List<InfoLugar> lugares = new ArrayList<InfoLugar> ();
    
    public Gestor(){
    	usuario = new IO<Usuario>("usuarios.ser").leer();
    	//partida = new IO<Partida>("partidas.ser").leer();
    	guiones = new IO<InfoGuion>("guiones.ser").leer();
    	listaEspera = new IO<Jugador>("espera.ser").leer();
    }

}