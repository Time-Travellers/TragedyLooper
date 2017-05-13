package launcher;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import bbdd.Gestor;
import presentacion.controlador.GUIController;
import presentacion.modelo.GUIModelo;
import presentacion.vista.FrameUI;
import presentacion.vista.usuario.IniciarSesionUI;

public class Main {

	public static void main(String[] args) {
		Log.setupLogging(Level.SEVERE);
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
