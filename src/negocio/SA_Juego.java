package negocio;

import integracion.factorias.DAO_FactoryGuion;
import integracion.factorias.DAO_FactoryGuionesPropuestos;
import presentacion.modelo.juego.InfoGuion;

public class SA_Juego{
	
	public boolean proponerGuion(InfoGuion guion){
		if(DAO_FactoryGuion.getFactoria().creaDAO().leer(guion.getTitulo()) == null && 
				DAO_FactoryGuionesPropuestos.getFactoria().creaDAO().leer
				(guion.getTitulo()) == null) {
			DAO_FactoryGuionesPropuestos.getFactoria().creaDAO().crear(guion);
			return true;
		} else
			return false;
	}
}
