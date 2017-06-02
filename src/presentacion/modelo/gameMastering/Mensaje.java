package presentacion.modelo.gameMastering;

import java.util.Date;

import presentacion.modelo.usuario.Usuario;

public class Mensaje {
	Usuario remitente;
	Usuario destinatario;
	String mensaje;
	String asunto;
	Date fecha;

	public Mensaje(Usuario remi, Usuario dest, String mensaje, String asunto, Date fecha) {
		this.remitente = remi;
		this.destinatario = dest;
		this.mensaje = mensaje;
		this.asunto = asunto;
		this.fecha = fecha;
	}

	/**
	 * Una persona solo puede enviar un mensaje a la vez.
	 * 
	 * @return
	 */
	public String getHash() {
		return remitente.getId() + fecha.toString();
	}

	public String toString() {
		return mensaje;
	}
}
