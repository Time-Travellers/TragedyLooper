package integracion.DAO;

public abstract class DAO<T> {

	public abstract void crear(T obj);

	public abstract T leer(String id);

	public abstract void actualizar(T obj);

	public abstract void borrar(String id);

}
