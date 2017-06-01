package integracion.factorias;

import java.util.HashMap;

import integracion.DAO.DAO;
import integracion.DAO.DAO_Lista;

public abstract class DAO_AbstractFactory<T>{
	public abstract DAO<T> creaDAO();
	public abstract DAO_Lista<HashMap<String,T>> creaListaDAO();
}


