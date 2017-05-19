package presentacion.modelo.usuario;

import java.io.Serializable;

public class Datos implements Serializable{
	
	private static final long serialVersionUID = 2635476380326929773L;

	private String nombre;

	private int edad;

	private Paises pais;

	private String correo;

	// Para que solo sea accesible desde el paquete
	Datos(String nombre, int edad, Paises pais, String correo) {
		this.nombre = nombre;
		this.edad = edad;
		this.pais = pais;
		this.correo = correo;
	}

	public Paises getPais() {
		return pais;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setPais(Paises pais) {
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void Actualizar() {
		// begin of modifiable
		// zone(JavaCode)......C/5fcb4eab-78bb-4973-9e36-0d002beaf914

		// end of modifiable
		// zone(JavaCode)........E/5fcb4eab-78bb-4973-9e36-0d002beaf914
	}

}
