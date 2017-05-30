package bbdd;

import java.util.HashMap;

import presentacion.modelo.gameMastering.Reporte;
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Usuario;

public class Gestor {
    public HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();

   // public HashMap<String, Partida> partidas = new HashMap<String, Partida> ();

    public HashMap<String, Jugador> listaEspera = new HashMap<String, Jugador> ();

    public HashMap<String, InfoGuion> guiones = new HashMap<String, InfoGuion> ();

    public HashMap<String, Reporte> reportados = new HashMap<String, Reporte> ();
    
    public HashMap<String, InfoGuion>  guiones_propuestos = new HashMap<String, InfoGuion> ();
    

    public Gestor(){
    	usuarios = new IO<Usuario>("usuarios.ser").leer();
    	//partidas = new IO<Partida>("partidas.ser").leer();
    	guiones = new IO<InfoGuion>("guiones.ser").leer();
    	listaEspera = new IO<Jugador>("espera.ser").leer();
    	reportados = new IO<Reporte>("reportados.ser").leer();
    	guiones_propuestos = new IO<InfoGuion>("guiones_propuestos.ser").leer();
    }
    
    public void close() {
    	new IO<Usuario>("usuarios.ser").almacenar(usuarios);
    	//new IO<Partida>("partidas.ser").almacenar(partidas);
    	new IO<InfoGuion>("guiones.ser").almacenar(guiones);
    	new IO<Jugador>("espera.ser").almacenar(listaEspera);
    	new IO<Reporte>("reportados.ser").almacenar(reportados);
    	new IO<InfoGuion>("guiones_propuestos.ser").almacenar(guiones_propuestos);
    }

}