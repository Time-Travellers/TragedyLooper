package presentacion.controlador;

public class ComprarRelojEvent{
	public enum ComprarRelojType{
		Comprar,VerAnuncio
	}
	
	ComprarRelojType tipo;
	
	public ComprarRelojEvent(ComprarRelojType t){
		tipo = t;
	}
	
	public String getComprarRelojType(){
		return tipo.toString();
	}
	
}
