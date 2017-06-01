package integracion.factorias;

import java.util.HashMap;

import integracion.DAO.DAO;
import integracion.DAO.DAO_Guiones;
import integracion.DAO.DAO_Lista;
import integracion.DAO.DAO_ListaGuiones;
import presentacion.modelo.juego.InfoGuion;

public class DAO_FactoryGuion extends DAO_AbstractFactory<InfoGuion>{

	@Override
	public DAO_Lista<HashMap<String, InfoGuion>> creaListaDAO() {
		return new DAO_ListaGuiones();
	}

	@Override
	public DAO<InfoGuion> creaDAO() {
		return new DAO_Guiones();
	}

}
