package integracion;

import java.util.HashMap;
import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.gameMastering.Reporte;

public class DAO_ListaReportados extends DAO_Lista <HashMap<String, Reporte>>{

	public DAO_ListaReportados(Gestor g) {
		super(g);
	}
	@Override
	public HashMap<String, Reporte> leer() {
		Logger.getLogger("log").info("Acceso a BBDD de reportados para leer objeto");
		return gestor.reportados;
	}

}
