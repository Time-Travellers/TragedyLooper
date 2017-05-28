package launcher;

import java.awt.Dimension;
import java.awt.Toolkit;
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
		
		// Inicializar 4 MVC con el mismo gestor
		iniciarModoEntrega(gestor);

	}

	private static void iniciarModoEntrega(Gestor gestor) {
		
		double anchura=Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double altura=Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		Dimension vDim = new Dimension ((int)anchura/2-1, (int) altura/2-1);
		System.out.println(vDim.getWidth()+" "+vDim.getHeight());
		
		FrameUI v1 = new FrameUI("Tragedy Looper 1", vDim, 0, 0);
		FrameUI v2 = new FrameUI("Tragedy Looper 2", vDim, (int) anchura/2, 0);
		FrameUI v3 = new FrameUI("Tragedy Looper 3", vDim, 0, (int) altura/2);
		FrameUI v4 = new FrameUI("Tragedy Looper 4", vDim, (int) anchura/2, (int) altura/2);
		
		//Iniciar controllers
		GUIController.setGestor(gestor);
		v1.setCtrl(new GUIController(v1));
		v2.setCtrl(new GUIController(v2));
		v3.setCtrl(new GUIController(v3));
		v4.setCtrl(new GUIController(v4));
	
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				v1.add(new IniciarSesionUI(v1.getCtrl()));
				v2.add(new IniciarSesionUI(v2.getCtrl()));
				v3.add(new IniciarSesionUI(v3.getCtrl()));
				v4.add(new IniciarSesionUI(v4.getCtrl()));
				//TODO esto es solo porque no se repinta y el repaint() no funciona. Solucionarlo
				v1.setVisible(true);v2.setVisible(true);v3.setVisible(true);v4.setVisible(true);
			}
		});
	}
	
}
