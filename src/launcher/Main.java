package launcher;

import java.util.logging.Level;

import javax.swing.SwingUtilities;

import bbdd.Gestor;
import presentacion.vista.usuario.IniciarSesionUI;

public class Main {

	public static void main(String[] args) {
		Log.setupLogging(Level.SEVERE);
		Gestor gestor = new Gestor();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new IniciarSesionUI();
			}
		});
		// Nuevo modelo
		// Nuevo controlador(vista, modelo, gestor)
		// Linkar vista y controlador
	}

}
