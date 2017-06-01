package integracion;

import java.util.HashMap;

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
