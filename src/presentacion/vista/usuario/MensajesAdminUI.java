package presentacion.vista.usuario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.Border;

public class MensajesAdminUI extends JPanel{
	
	PanelGrande panel;
	
	public MensajesAdminUI(int n){
		this.panel=(new PanelGrande("Bandeja de Entrada", n));
		this.add(panel);
	}
	
	public void setListener(ActionListener listener){
		panel.setListener(listener);
	}

public static void main(String args[]){
	JFrame ventana=new JFrame("prueba");
	ventana.setSize(800,600);
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ventana.setContentPane(new MensajesAdminUI(10));
	ventana.setVisible(true);
}
	}
