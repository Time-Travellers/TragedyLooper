package integracion.DAO;

import java.util.HashMap;
import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.gameMastering.Reporte;

public class DAO_ListaReportados extends DAO_Lista <HashMap<String, Reporte>>{

	@Override
	public HashMap<String, Reporte> leer() {
		Logger.getLogger("log").info("Acceso a BBDD de reportados para leer objeto");
		return Gestor.getGestor().reportados;
	}

}
