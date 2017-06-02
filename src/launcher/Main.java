package launcher;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import presentacion.controlador.GUIController;
import presentacion.vista.FrameUI;
import presentacion.vista.usuario.iniciarsesion.IniciarSesionUI;

public class Main {

	public static void main(String... args) {
		Log.setupLogging(Level.SEVERE);

		if (args.length > 0 && args[0].equals("entrega"))
			// Inicializar 4 MVC con el mismo gestor para presentacion en clase
			iniciarModoEntrega();
		else
			iniciarNormal();

	}

	private static void iniciarNormal() {
		FrameUI v = new FrameUI("Tragedy Looper", Toolkit.getDefaultToolkit().getScreenSize());
		GUIController ctrl = new GUIController(v);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				IniciarSesionUI ini = new IniciarSesionUI();
				ini.addIniSesionListener(ctrl);
				v.add(ini);
				v.setVisible(true);
			}
		});
	}

	private static void iniciarModoEntrega() {

		double anchura = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double altura = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		Dimension vDim = new Dimension((int) anchura / 2 - 1, (int) altura / 2 - 1);
		Logger.getLogger("log").info("Dimensiones: Ancho - " + vDim.getWidth() + ", Alto - " + vDim.getHeight());

		final int[] posAncho = new int[] { 0, (int) (anchura / 2), 0, (int) (anchura / 2) };
		final int[] posAlto = new int[] { 0, 0, (int) (altura / 2), (int) (altura / 2) };

		for (int i = 0; i < 4; ++i) {
			FrameUI v = new FrameUI("Tragedy Looper " + (i + 1), vDim, posAncho[i], posAlto[i]);
			GUIController ctrl = new GUIController(v);
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					IniciarSesionUI ini = new IniciarSesionUI();
					ini.addIniSesionListener(ctrl);
					v.add(ini);
					v.setVisible(true);
				}
			});
		}

	}
}
