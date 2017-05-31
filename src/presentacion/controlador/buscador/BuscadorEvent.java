package presentacion.controlador.buscador;

public class BuscadorEvent{
	public enum BuscadorType{
		Buscar, Salir
	}
	
	private BuscadorType tipo;
	private String busq;
	
	public BuscadorEvent(BuscadorType t, String busq){
		this.tipo = t;
		this.busq = busq;
	}
	
	public String getBuscadorType(){
		return tipo.toString();
	}
	
	public String getBusq(){
		return busq;
	}
	
}
