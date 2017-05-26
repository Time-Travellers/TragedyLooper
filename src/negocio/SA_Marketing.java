package negocio;

import integracion.DAO_Guiones;

import java.util.ArrayList;

import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.marketing.Tienda;
import presentacion.vista.marketing.comprarreloj.InfoNivel;
import bbdd.Gestor;

public class SA_Marketing implements SA {
	public Tienda iniciarTienda(Gestor gestor) {
		ArrayList<InfoNivel> list = new ArrayList<InfoNivel>(Tienda.NIVEL);
		ArrayList<InfoGuion> guiones = new DAO_Guiones(gestor).leerGuiones();
		for(int i=0;i<guiones.size();++i){
			list.get(guiones.get(i).getNivel()).getGuiones().add(guiones.get(i).getTitulo());
		}
		return new Tienda(list);
	}
	
	
}
