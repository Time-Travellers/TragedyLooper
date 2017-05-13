package presentacion.modelo.usuario;


public abstract class Usuario {
    private String id;

    private String password;

    private Datos datos;

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
