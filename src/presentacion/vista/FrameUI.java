package presentacion.vista;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import presentacion.controlador.GUIController;

public class FrameUI extends JFrame {
	
	private static final long serialVersionUID = 3437382482094237259L;
	private GUIController ctrl;
	
	public FrameUI(String title) {
		super(title);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
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
