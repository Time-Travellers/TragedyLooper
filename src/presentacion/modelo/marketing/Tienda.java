package presentacion.modelo.marketing;

import java.util.ArrayList;
import java.util.Arrays;

public class Tienda {
	
	public static final int NIVEL = 9;
	public static final int NUMANUNCIOS = 3;
	public static final ArrayList<InfoReloj> PAQUETESRELOJ =
			new ArrayList<InfoReloj>(Arrays.asList(
					new InfoReloj("Paquete Basico", 20, 9.99),
					new InfoReloj("Paquete Intermedio", 50, 19.99),
					new InfoReloj("Paquete Avanzado",100, 34.99),
					new InfoReloj("Paquete Experto",250, 79.99),
					new InfoReloj("Paquete Viajero del Tiempo",500, 149.99),
					new InfoReloj("¡Oferta por tiempo limitado!",25, 9.99)
					));
	private ArrayList<InfoNivel> paquetesNivel;
	
	public Tienda(ArrayList<InfoNivel> paquetesNivel){
		this.paquetesNivel = paquetesNivel;
	}
	
	public ArrayList<InfoNivel> getPaquetesNivel (){
		return paquetesNivel;		
	}
}
