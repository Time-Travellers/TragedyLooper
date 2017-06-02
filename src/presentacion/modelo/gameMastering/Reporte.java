package presentacion.modelo.gameMastering;

import java.io.Serializable;
import java.util.Date;

import presentacion.modelo.usuario.Usuario;

public class Reporte implements Serializable {

	private static final long serialVersionUID = 3029637258999405310L;

	Usuario reportador;
	Usuario reportado;
	Date fecha;

	public Reporte(Usuario reportador, Usuario reportado, Date fecha) {
		this.reportador = reportador;
		this.reportado = reportado;
		this.fecha = fecha;
	}

	public String getHash() {
		return reportador.getId() + reportado.getId() + fecha.toString();
	}

	public Usuario getReportador() {
		return reportador;
	}

	public Usuario getReportado() {
		return reportado;
	}

	public Date getFecha() {
		return fecha;
	}
}
