package presentacion.modelo.usuario;

import java.util.ArrayList;
import java.util.Date;

import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.juego.JugadorPartida;

public class Administrador extends Usuario {
 
	private static final long serialVersionUID = -6954434759575092156L;
	
	public Administrador(String id, String password, boolean admin, String nombre, int edad, Paises pais, String correo) {
    	this.id = id;
    	this.password = password;
    	this.admin = admin;
    	this.datos = new Datos(nombre, edad, pais, correo);
  	
    }

	public void banearUser(Date fecha, String user) {
//begin of modifiable zone(JavaCode)......C/7b7b0820-26fa-4f32-8c75-8cf455d3c22c

//end of modifiable zone(JavaCode)........E/7b7b0820-26fa-4f32-8c75-8cf455d3c22c
    }

    public void aceptarGuion(InfoGuion guion) {
//begin of modifiable zone(JavaCode)......C/bd53dc76-6352-4f6b-8595-93a6af0925ac

//end of modifiable zone(JavaCode)........E/bd53dc76-6352-4f6b-8595-93a6af0925ac
    }

    public void contactarUsuario(String usuario) {
//begin of modifiable zone(JavaCode)......C/2e6858da-f981-45b4-8b1c-7eef0db4547d

//end of modifiable zone(JavaCode)........E/2e6858da-f981-45b4-8b1c-7eef0db4547d
    }

}
