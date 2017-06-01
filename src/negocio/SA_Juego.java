package negocio;

import integracion.DAO_Guiones;
import integracion.DAO_Guiones_Propuestos;
import presentacion.modelo.juego.InfoGuion;

public class SA_Juego{
	
	public boolean proponerGuion(InfoGuion guion){
		if(new DAO_Guiones().leer(guion.getTitulo()) == null && 
				new DAO_Guiones_Propuestos().leer(guion.getTitulo()) == null) {
			new DAO_Guiones_Propuestos().crear(guion);
			return true;
		} else
			return false;
	}
}
