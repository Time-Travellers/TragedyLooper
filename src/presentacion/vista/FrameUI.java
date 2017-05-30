package presentacion.vista;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import presentacion.controlador.GUIController;
import presentacion.vista.usuario.inicioadmin.InicioAdminUI;

public class FrameUI extends JFrame {
	
	private static final long serialVersionUID = 3437382482094237259L;
	private GUIController ctrl;
	
	public FrameUI(String title, Dimension dim, int posX, int posY) {
		super(title);
//		BufferedImage img = null;
//		try {
//			img = ImageIO.read(InicioAdminUI.class.getResource("/resources/fondo.png"));
//		} catch (IOException e1) {
//			Logger.getLogger("log").severe("Error al cargar la imagen de fondo de las pantallas");
//		}
//		this.setContentPane(new JLabel(new ImageIcon(img)));
		//this.setLayout(new FlowLayout());
		this.setSize(dim);
		this.setLocation(posX, posY);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				ctrl.closeGestor();
			}
		});
		
	}
	
	public void setCtrl(GUIController ctrl) {
		this.ctrl = ctrl;
	}
	
	public GUIController getCtrl(){
		return ctrl;
	}
}
