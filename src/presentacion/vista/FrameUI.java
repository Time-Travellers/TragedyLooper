package presentacion.vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import presentacion.controlador.GUIController;

public class FrameUI extends JFrame {
	
	private static final long serialVersionUID = 3437382482094237259L;
	private GUIController ctrl;
	
	public FrameUI(String title, Dimension dim, int posX, int posY) {
		super(title);
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
