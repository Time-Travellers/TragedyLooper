package presentacion.controlador.comprarreloj;

import presentacion.modelo.marketing.InfoReloj;
import presentacion.modelo.usuario.Jugador;

public class ComprarRelojEvent{
	public enum ComprarRelojType{
		Comprar,VerAnuncio
	}
	
	private ComprarRelojType tipo;
	private Jugador jugador;
	private InfoReloj info;
	
	public ComprarRelojEvent(ComprarRelojType t, Jugador jugador){
		this.jugador = jugador;
		this.tipo = t;
	}
	
	public ComprarRelojEvent(ComprarRelojType t, Jugador jugador,InfoReloj info){
		this.jugador = jugador;
		this.info = info;
		this.tipo = t;
	}
	
	public String getComprarRelojType(){
		return tipo.toString();
	}
	
	public Jugador getJugador(){
		return jugador;
	}
	
	public InfoReloj getInfo(){
		return info;
	}
	
}
