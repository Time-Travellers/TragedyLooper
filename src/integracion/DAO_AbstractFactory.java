package integracion;

import java.util.HashMap;

public abstract class DAO_AbstractFactory<T>{
	public abstract DAO<T> creaDAO();
	public abstract DAO_Lista<HashMap<String,T>> creaListaDAO();
}
