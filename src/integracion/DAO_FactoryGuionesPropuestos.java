package integracion;

import java.util.HashMap;

import presentacion.modelo.juego.InfoGuion;

public class DAO_FactoryGuionesPropuestos extends DAO_AbstractFactory<InfoGuion> {

	@Override
	public DAO<InfoGuion> creaDAO() {
		return new DAO_Guiones_Propuestos();
	}

	@Override
	public DAO_Lista<HashMap<String, InfoGuion>> creaListaDAO() {
		return new DAO_ListaGuionesPropuestos();
	}
}
