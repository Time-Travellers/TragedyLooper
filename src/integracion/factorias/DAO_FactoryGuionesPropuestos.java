package integracion.factorias;

import java.util.HashMap;

import integracion.DAO.DAO;
import integracion.DAO.DAO_Guiones_Propuestos;
import integracion.DAO.DAO_Lista;
import integracion.DAO.DAO_ListaGuionesPropuestos;
import presentacion.modelo.juego.InfoGuion;

public class DAO_FactoryGuionesPropuestos extends DAO_AbstractFactory<InfoGuion> {

	private static DAO_FactoryGuionesPropuestos fabricaDeGuionesPropuestos;

	public static DAO_FactoryGuionesPropuestos getFactoria() {
		if (fabricaDeGuionesPropuestos == null)
			fabricaDeGuionesPropuestos = new DAO_FactoryGuionesPropuestos();
		return fabricaDeGuionesPropuestos;
	}

	@Override
	public DAO<InfoGuion> creaDAO() {
		return new DAO_Guiones_Propuestos();
	}

	@Override
	public DAO_Lista<HashMap<String, InfoGuion>> creaListaDAO() {
		return new DAO_ListaGuionesPropuestos();
	}
}
