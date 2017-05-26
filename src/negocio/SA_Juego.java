package negocio;

import integracion.DAO_Guiones_Propuestos;
import bbdd.Gestor;
import presentacion.modelo.juego.InfoGuion;

public class SA_Juego implements SA {
	
	public void proponerGuion(Gestor gestor, InfoGuion guion){
		new DAO_Guiones_Propuestos(gestor).crear(guion);
	}
}
