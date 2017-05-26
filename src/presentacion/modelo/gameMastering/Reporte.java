package presentacion.modelo.gameMastering;

import java.util.Date;

import presentacion.modelo.usuario.Usuario;

public class Reporte {

	Usuario reportador;
	Usuario reportado;
	Date fecha;
	
	public Reporte(Usuario reportador, Usuario reportado, Date fecha) {
		this.reportador = reportador;
		this.reportado = reportado;
		this.fecha = fecha;
	}
	
}
