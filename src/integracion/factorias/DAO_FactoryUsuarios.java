package integracion.factorias;

import java.util.HashMap;

import integracion.DAO.DAO;
import integracion.DAO.DAO_Lista;
import integracion.DAO.DAO_ListaUsuarios;
import integracion.DAO.DAO_Usuarios;
import presentacion.modelo.usuario.Usuario;

public class DAO_FactoryUsuarios extends DAO_AbstractFactory<Usuario>{
	
	@Override
	public DAO<Usuario> creaDAO() {
		return new DAO_Usuarios();
	}

	@Override
	public DAO_Lista<HashMap<String, Usuario>> creaListaDAO() {
		return new DAO_ListaUsuarios();
	}

}
