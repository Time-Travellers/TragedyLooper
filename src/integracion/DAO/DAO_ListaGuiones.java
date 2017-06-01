package integracion.DAO;

import java.util.HashMap;
import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.juego.InfoGuion;

public class DAO_ListaGuiones extends DAO_Lista<HashMap<String, InfoGuion>>{

	@Override
	public HashMap<String, InfoGuion> leer() {
		Logger.getLogger("log").info("Acceso a BBDD de guiones para leer objeto");
		return Gestor.getGestor().guiones;
	}

}
