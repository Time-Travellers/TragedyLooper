package launcher;

import java.util.logging.Level;

import javax.swing.SwingUtilities;

import bbdd.Gestor;
import presentacion.controlador.GUIController;
import presentacion.modelo.GUIModelo;
import presentacion.vista.FrameUI;
import presentacion.vista.usuario.iniciarsesion.IniciarSesionUI;

public class Main {

	public static void main(String[] args) {
		Log.setupLogging(Level.INFO);
		Gestor gestor = new Gestor();
		
		GUIModelo modelo = new GUIModelo();
		FrameUI ventana = new FrameUI("Tragedy Looper");
		GUIController ctrl = new GUIController(ventana, modelo, gestor);
		ventana.setCtrl(ctrl);
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ventana.add(new IniciarSesionUI(ctrl));
			}
		});
		ventana.setVisible(true);
		
	}

}
