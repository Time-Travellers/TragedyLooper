package presentacion.modelo.marketing;

import java.util.ArrayList;

import presentacion.vista.marketing.comprarreloj.InfoNivel;
import presentacion.vista.marketing.comprarreloj.InfoReloj;

public class Tienda {
	
	public static final int NIVEL = 4;
	public static final int NUMANUNCIOS = 3;
	private ArrayList<InfoReloj> paquetesReloj;
	private ArrayList<InfoNivel> paquetesNivel;
	
	public Tienda(ArrayList<InfoNivel> paquetesNivel){
		inicializeReloj();
		this.paquetesNivel = paquetesNivel;
	}
	
	private void inicializeReloj(){
		paquetesReloj = new ArrayList<InfoReloj>();
		paquetesReloj.add(new InfoReloj("Paquete Basico", 20, 9.99));
		paquetesReloj.add(new InfoReloj("Paquete Intermedio", 50, 19.99));
		paquetesReloj.add(new InfoReloj("Paquete Avanzado",100, 34.99));
		paquetesReloj.add(new InfoReloj("Paquete Experto",250, 79.99));	
		paquetesReloj.add(new InfoReloj("Paquete Viajero del Tiempo",500, 149.99));	
		paquetesReloj.add(new InfoReloj("¡Oferta por tiempo limitado!",25, 9.99));	
	}
	
	public ArrayList<InfoReloj> getPaquetesReloj (){
		return paquetesReloj;		
	}
	
	public ArrayList<InfoNivel> getPaquetesNivel (){
		return paquetesNivel;		
	}
}
