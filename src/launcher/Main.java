package launcher;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import bbdd.Gestor;
import presentacion.modelo.GUIModelo;
import presentacion.vista.usuario.IniciarSesionUI;

public class Main {

	public static void main(String[] args) {
		Log.setupLogging(Level.SEVERE);
		Gestor gestor = new Gestor();
		
		JFrame ventana = new JFrame("Tragedy Looper");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ventana.add(new IniciarSesionUI());
			}
		});
		ventana.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				gestor.close();
			}
		});
		ventana.setVisible(true);
		
		GUIModelo modelo = new GUIModelo();
		// Nuevo controlador(vista, modelo, gestor)
		// Linkar vista y controlador
	}

}
