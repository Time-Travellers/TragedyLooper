package negocio;

import bbdd.Gestor;
import presentacion.modelo.juego.InfoGuion;

public class SA_Juego implements SA {
	
	public boolean proponerGuion(Gestor gestor, InfoGuion guion){
		DAO_Guiones_Propuestos dao = new DAO_Guiones_Propuestos(gestor).crear(guion);
	}
}
