package integracion.factorias;

import java.util.HashMap;

import integracion.DAO.DAO;
import integracion.DAO.DAO_Lista;
import integracion.DAO.DAO_ListaReportados;
import integracion.DAO.DAO_Reportados;
import presentacion.modelo.gameMastering.Reporte;

public class DAO_FactoryReportados extends DAO_AbstractFactory<Reporte> {

	private static DAO_FactoryReportados fabricaDeReportes;

	public static DAO_FactoryReportados getFactoria() {
		if (fabricaDeReportes == null)
			fabricaDeReportes = new DAO_FactoryReportados();
		return fabricaDeReportes;
	}

	@Override
	public DAO<Reporte> creaDAO() {
		return new DAO_Reportados();
	}

	@Override
	public DAO_Lista<HashMap<String, Reporte>> creaListaDAO() {
		return new DAO_ListaReportados();
	}

}
