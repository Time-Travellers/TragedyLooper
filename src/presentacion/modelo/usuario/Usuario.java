package presentacion.modelo.usuario;

import java.io.Serializable;

public abstract class Usuario implements Serializable{
   
	private static final long serialVersionUID = -2180578030466510037L;

	protected String id;

    protected String password;

    protected Datos datos;
    
    protected boolean admin;

    public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Datos getDatos() {
		return datos;
	}

	public void setDatos(Datos datos) {
		this.datos = datos;
	}

	public boolean modificarDatos() {
    	
    }

    public String verDatos() {
    	
    }

    public Usuario buscarUsuario() {
    }

}
