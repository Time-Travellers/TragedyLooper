package negocio;

import integracion.DAO_Guiones;
import integracion.DAO_Guiones_Propuestos;
import bbdd.Gestor;
import presentacion.modelo.juego.InfoGuion;

public class SA_Juego{
	
	public boolean proponerGuion(Gestor gestor, InfoGuion guion){
		if(new DAO_Guiones(gestor).leer(guion.getTitulo()) == null && 
				new DAO_Guiones_Propuestos(gestor).leer(guion.getTitulo()) == null) {
			new DAO_Guiones_Propuestos(gestor).crear(guion);
			return true;
		} else
			return false;
	}
}
