package integracion;

import java.util.HashMap;
import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.juego.InfoGuion;

public class DAO_ListaGuionesPropuestos extends DAO_Lista<HashMap<String,InfoGuion>>{

	public DAO_ListaGuionesPropuestos(Gestor g) {
		super(g);
	}
	
	@Override
	public HashMap<String, InfoGuion> leer() {
		Logger.getLogger("log").info("Acceso a BBDD de guiones propuestos para leer objeto");
		return gestor.guiones_propuestos;
	}
}
