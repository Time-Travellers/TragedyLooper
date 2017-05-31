package presentacion.modelo.usuario;

public class Administrador extends Usuario {
 
	private static final long serialVersionUID = -6954434759575092156L;
	
	public Administrador(String id, String password, boolean admin, String nombre, int edad, Paises pais, String correo) {
    	this.id = id;
    	this.password = password;
    	this.admin = admin;
    	this.datos = new Datos(nombre, edad, pais, correo);
  	
    }

}
