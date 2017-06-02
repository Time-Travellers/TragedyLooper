package integracion.DAO;

import java.util.logging.Logger;

import bbdd.Gestor;
import presentacion.modelo.gameMastering.Reporte;

public class DAO_Reportados extends DAO<Reporte> {

	@Override
	public void crear(Reporte obj) {
		Gestor.getGestor().reportados.put(obj.getHash(), obj);
		Logger.getLogger("log").info("Acceso a BBDD de reportados para crear objeto");
	}

	@Override
	public Reporte leer(String hash) {
		Logger.getLogger("log").info("Acceso a BBDD de reportados para leer objeto");
		return Gestor.getGestor().reportados.get(hash);
	}

	@Override
	public void actualizar(Reporte obj) {
		Logger.getLogger("log").info("Acceso a BBDD de reportados para actualizar objeto");
		Gestor.getGestor().reportados.put(obj.getHash(), obj);
	}

	@Override
	public void borrar(String id) {
		Logger.getLogger("log").info("Acceso a BBDD de usuarios para borrar objeto");
		Gestor.getGestor().usuarios.remove(id);
	}

}
