package integracion.factorias;

import java.util.HashMap;

import bbdd.Gestor;
import integracion.DAO.DAO;
import integracion.DAO.DAO_Guiones;
import integracion.DAO.DAO_Lista;
import integracion.DAO.DAO_ListaGuiones;
import presentacion.modelo.juego.InfoGuion;

public class DAO_FactoryGuion extends DAO_AbstractFactory<InfoGuion>{


	private static DAO_FactoryGuion fabricaDeGuiones;
	
    public static DAO_FactoryGuion getGestor(){
    	if(fabricaDeGuiones==null)
    		fabricaDeGuiones = new DAO_FactoryGuion();
    	return fabricaDeGuiones;
    }
	
    
	@Override
	public DAO_Lista<HashMap<String, InfoGuion>> creaListaDAO() {
		return new DAO_ListaGuiones();
	}

	@Override
	public DAO<InfoGuion> creaDAO() {
		return new DAO_Guiones();
	}

}

