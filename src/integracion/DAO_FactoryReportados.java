package integracion;

import java.util.HashMap;

import presentacion.modelo.gameMastering.Reporte;

public class DAO_FactoryReportados extends DAO_AbstractFactory<Reporte>  {

	@Override
	public DAO<Reporte> creaDAO() {
		return new DAO_Reportados();
	}

	@Override
	public DAO_Lista<HashMap<String, Reporte>> creaListaDAO() {
		return new DAO_ListaReportados();
	}

}
